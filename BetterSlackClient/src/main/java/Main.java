public class Main {

    public static void main(String[] args) {


        NetworkBasedChatClient client = new TcpChatClient();

        client.connect("localhost", 50000);

        UserInputProvider inputProvider = new ConsoleInputProvider();

        while (client.isOnline()){
           String inputText = inputProvider.getUserInput();
           client.sendMessage(inputText);
        }
        System.out.println("bye bye");
    }

}
