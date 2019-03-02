
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        ClientSimple client = new ClientSimple();

        client.connectToServer("127.0.0.1", 3024);
        // "192.168.1.53", 65535) Michał
        // "192.168.1.74", 55555)Michał Ż
      //  client.disconnectToServer("127.0.0.1", 3024);

    }


}
