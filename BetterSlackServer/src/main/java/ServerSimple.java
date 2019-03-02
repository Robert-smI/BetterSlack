import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSimple {

private ServerSocket serverSocket;
private Socket clientSocket;
private BufferedReader input;

public void serverStart (int port) throws IOException {
    serverSocket = new ServerSocket(port);
    System.out.println("server start");
    clientSocket = serverSocket.accept();
    System.out.println("client connected");

//    while (clientSocket.isClosed()){
//        System.out.println("client siconnected");
//    }

    input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

  //  String message = input.readLine();

//    while (!message.contains("exit")) {
//    System.out.println(input.readLine());
//

    while (true){
        String newmessage = input.readLine();
        System.out.println(input.readLine());
        if (newmessage.equals("exit")){
            break;
        }
    }


    }


}



