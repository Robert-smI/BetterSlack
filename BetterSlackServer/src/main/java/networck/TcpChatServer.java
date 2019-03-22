package networck;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpChatServer implements ChatServer {

    private ServerSocket serverSocket;
    private List<ChatClient> onlineUsers = new ArrayList<>();  // older Socket
    private Thread acceptingSocketThread;



    @Override
    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server is running %d...\n" +port);
        acceptingSocketThread = new Thread(this::startAcceptingClients);
        acceptingSocketThread.start();
    }

    private void startAcceptingClients (){
        while (isOnline()){
            try {
                Socket clientSocket = serverSocket.accept();
                ChatClient client = new TcpChatClient(clientSocket);
                onlineUsers.add(client);
                System.out.println("New client has joined. Online users: " + onlineUsers.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void shutdown() {
        if (isOnline()){
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isOnline() {
        return  serverSocket != null &&  !serverSocket.isClosed();
    }

    @Override
    public void clientDisconnected(ChatClient client) {
        onlineUsers.remove(client);
        System.out.println("Client left the building. Clients online: "+ onlineUsers.size());
    }

}
