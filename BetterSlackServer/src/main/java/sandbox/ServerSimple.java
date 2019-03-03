package sandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSimple {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader clientInput;
    private  static final String EXIT_KEYWORD = "exit";
    private List<Socket> connectedClients = new ArrayList<Socket>();
    private boolean isOnline;
    private Thread acceptingThread;


    public void serverStart(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("server start");

        isOnline = true;

        acceptingThread = new Thread(() -> {
            while (isOnline) {
                Socket clientSocket = null;
                try {
                    clientSocket = serverSocket.accept();
                } catch (IOException e) {
                    isOnline = false;
                    System.out.println("Server has been disconnected");
                    break;
                }
                connectedClients.add(clientSocket);
                System.out.println("Client has been connected. " +
                        "Users online: " + connectedClients.size());

            }
            System.out.println("Server has been disconnected");
        });

        acceptingThread.start();
    }
    public void shutdown() {
        isOnline = false;
    }


    
}
