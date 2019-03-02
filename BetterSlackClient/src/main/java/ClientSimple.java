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

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String newMesage = scanner.nextLine();
                output.println();
            if (newMesage.equals("exit")){
                break;
            }
        }

    }

    public void disconnectToServer  (String ipAdress, int port) throws IOException {
        socket = new Socket(ipAdress,port);
        socket.isClosed();
    }
}
