import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpChatClient implements NetworkBasedChatClient {

    private Socket clientSocket;
    private PrintWriter output;  // wysyla
    private BufferedReader input;
    private Thread readingThread;

    @Override
    public void connect(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            startReading();
        } catch (IOException e) {
            throw new IllegalStateException("Could not connect to the server at: " +
                    ip + ":" + port);
        }
    }

    private void startReading() {
        readingThread = new Thread(() -> {
            while (isOnline()) {
                readMessage();
            }
            System.out.println("Lost connect with the server.");
        });
        readingThread.start();
    }

    private void readMessage() {
        try {
            String message = input.readLine();
            if (message == null) {
                disconnect();
                return;
            }
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void disconnect() {
        if (isOnline()) {
            try {
                clientSocket.close();
            } catch (IOException e) {
                // no comments needed
            }
            clientSocket = null;
        }
    }

    @Override
    public void sendMessage(String txt) {
        output.println(txt);
    }

    @Override
    public boolean isOnline() {
        return clientSocket != null && !clientSocket.isClosed();
    }


}
