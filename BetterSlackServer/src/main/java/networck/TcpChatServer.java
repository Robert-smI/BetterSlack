package networck;

import networck.settings.ChannelSettings;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpChatServer implements ChatServer {

    private ServerSocket serverSocket;
    private List<ChatClient> onlineUsers = new ArrayList<>();  // older Socket
    private Thread acceptingSocketThread;
    private final ChannelRepository channelRepository;

    public TcpChatServer(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }


    @Override
    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server is running %d...\\n" + port);
        acceptingSocketThread = new Thread(this::startAcceptingClients);
        acceptingSocketThread.start();
    }


    private void startAcceptingClients() {
        while (isOnline()) {
            try {
                Socket clientSocket = serverSocket.accept();
                ChatClient client = new TcpChatClient(clientSocket);
                onlineUsers.add(client);
                channelRepository.findByName(ChannelSettings.DEFAULT_CHANNEL_NAME)
                .ifPresent(channel-> channel.join(client));
                System.out.println("New client has joined. Online users: " + onlineUsers.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void shutdown() {
        if (isOnline()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                // nothing to serve
            }
        }
    }

    @Override
    public boolean isOnline() {
        return serverSocket != null && !serverSocket.isClosed();
    }

    @Override
    public void clientDisconnected(ChatClient client) {
        onlineUsers.remove(client);
        channelRepository.findByName(ChannelSettings.DEFAULT_CHANNEL_NAME).ifPresent(channelint -> channelint.leave(client));
        System.out.println("Client left the building. Clients online: " + onlineUsers.size());
    }

}
