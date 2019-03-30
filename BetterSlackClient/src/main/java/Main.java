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
               client.sendMessageCommand((Message)userInput);

            } catch(EmptyMessageExeption ex) {
                System.out.println(ex.getMessage());
            }

          // ChatCommand inputText = inputProvider.getUserInput( );
         //  client.sendMessage(inputText);
        }

//        while(client.isOnline()) {
//            String userInput = inputProvider.getUserInputSimple();
//            client.sendMessage(userInput);
//        }


        client.sendMessage("hej");

        System.out.println("bye bye");
    }

}
