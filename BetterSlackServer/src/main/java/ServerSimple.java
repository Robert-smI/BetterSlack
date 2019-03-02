import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSimple {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader clientInput;
    private  static final String EXIT_KEYWORD = "exit";

    public void serverStart(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("server start");

        clientSocket = serverSocket.accept();
        System.out.println("client has been connected");


        clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (!clientSocket.isClosed()) {

            String receivedMessage = "";

            try {
                receivedMessage = clientInput.readLine();
            } catch(SocketException ex) {
                System.out.println("Client has been disconnected");
                break;
            }

            if(receivedMessage.toLowerCase().equals(EXIT_KEYWORD)) {
                break;
            }

            System.out.println(receivedMessage);

        }


    }


}



