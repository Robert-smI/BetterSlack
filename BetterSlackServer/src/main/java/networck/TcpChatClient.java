package networck;

import networck.settings.ChannelSettings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpChatClient implements ChatClient {

    private final Socket clientSocket;
    private PrintWriter output;   // wysyla
    private BufferedReader input;
    private Thread readThread;
    private String currentChannelName = ChannelSettings.DEFAULT_CHANNEL_NAME;
    private final ChannelRepository channelRepository;

  //  private final ChannelRepository channelRepository = new InMemoryChannelRepository();

    //private final Channel generalChannel =
     //       new InMemoryChannelRepository().findByName(ChannelSettings.DEFAULT_CHANNEL_NAME).get();

    private final List<DisconnectObserver> disconnectObservers = new ArrayList<>();

    public TcpChatClient(Socket clientSocket, ChannelRepository channelRepository) {
        this.clientSocket = clientSocket;
        try {
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new IllegalStateException("Error init client");
        }
        this.channelRepository = channelRepository;
        startReading();
    }

    private void startReading() {
        readThread = new Thread(() -> {
            while (isOnline()) {
                readMessage();
            }
            notifyDisconnected(this);
        }
        );
        readThread.start();
    }

    private void readMessage() {
        try {
            String msg = input.readLine();
            if (msg == null) {
                disconnect();
                return;
            }
            System.out.println(msg);
            channelRepository.findByName(currentChannelName).ifPresent(channel -> channel.broadcast(this, msg));

        } catch (IOException e) {
            disconnect();
            // TBD
        }
    }

    @Override
    public void sendMessage(String message) {
        if (isOnline() && !message.isEmpty() && message.trim().isEmpty()) {
            output.println(message);
        }
    }



    @Override
    public void disconnect() {
        if (isOnline()) {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                // Unhandled intentionally
            }
        }
    }

    @Override
    public boolean isOnline() {
        return clientSocket != null && !clientSocket.isClosed();
    }

    @Override
    public void changeCurrentChanel(String changename) {
        if (!changename.equals(currentChannelName)){
            channelRepository.findByName(changename)
                    .orElseThrow(() -> new IllegalStateException("Channel does not exist"));
            currentChannelName = changename;
        }
    }

    @Override
    public String getCurrentChhannelName() {

        return null;
    }


    // DisconnectObservable methods:
    @Override
    public void subscribe(DisconnectObserver observer) {
        disconnectObservers.add(observer);
    }

    @Override
    public void unsuscribe(DisconnectObserver observer) {
        disconnectObservers.remove(observer);
    }

    @Override
    public void notifyDisconnected(ChatClient chatClient) {
        for (DisconnectObserver observer : disconnectObservers
        ) {
            observer.clientDisconnected(chatClient);
        }
    }
}
