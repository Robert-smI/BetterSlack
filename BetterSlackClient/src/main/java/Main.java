import commands.ChatCommand;
import commands.Message;
import exeption.EmptyMessageExeption;

public class Main {

    public static void main(String[] args) {


        NetworkBasedChatClient client = new TcpChatClient();

        client.connect("192.168.1.74", 50000);

        UserInputProvider inputProvider = new ConsoleInputProvider();

        while (client.isOnline()){
            try {
                ChatCommand userInput = inputProvider.getUserInput( );

                client.sendMessage(userInput);
            } catch(EmptyMessageExeption ex) {
                System.out.println(ex.getMessage());
            }

           ChatCommand inputText = inputProvider.getUserInput( );
           client.sendMessage(inputText);
        }
        System.out.println("bye bye");

    }

}
