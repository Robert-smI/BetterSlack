import commands.ChatCommand;
import commands.Message;
import exeption.EmptyMessageExeption;

public class Main {

    public static void main(String[] args) {


        NetworkBasedChatClient client = new TcpChatClient();

        client.connect("localhost", 50000);    //  mz 192.168.1.74

        UserInputProvider inputProvider = new ConsoleInputProvider();

        while (client.isOnline()){
            try {
                ChatCommand userInput = inputProvider.getUserInput( );
                Message message = (Message)userInput;
                client.sendMessageCommand(message);

            } catch(EmptyMessageExeption ex) {
                System.out.println(ex.getMessage());
            }

        }

//        while(client.isOnline()) {
//            String userInput = inputProvider.getUserInputSimple();
//            client.sendMessage(userInput);
//        }

        System.out.println("bye bye");
    }

}
