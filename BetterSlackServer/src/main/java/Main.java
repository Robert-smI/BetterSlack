import networck.ChatServer;
import networck.TcpChatServer;

public class Main {

    public static void main(String[] args) {

        ChatServer server = new TcpChatServer();

        server.start(50000);

    }


}
