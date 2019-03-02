import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSimple {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
  private  static final String EXIT_KEYWORD = "exit";


    public void connectToServer  (String ipAdress, int port) throws IOException {
        socket = new Socket(ipAdress,port);
        socket.isClosed();
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true  );

        output.println("Hello from client");
        output.println("Hello 2 from client");
        output.println("exit");


        while (true) {
        Scanner scanner = new Scanner(System.in);
            String newMesage = scanner.nextLine();
                output.println(newMesage);
            if (newMesage.equals(EXIT_KEYWORD)){
                break;
            }
        }

    }

    public void disconnectToServer  (String ipAdress, int port) throws IOException {
        socket = new Socket(ipAdress,port);
        socket.isClosed();
    }
}
