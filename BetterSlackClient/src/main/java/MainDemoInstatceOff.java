import commands.ChatCommand;
import commands.Message;

public class MainDemoInstatceOff {


    public static void main(String[] args) {
        String TEST=null;


        UserInputProvider inputProvider = new ConsoleInputProvider();
        ChatCommand userInput = inputProvider.getUserInput( );

          System.out.println( userInput instanceof ChatCommand);
        System.out.println( userInput instanceof Message);
            if(userInput instanceof ChatCommand){
                TEST = "is instance";
            }
            else {
                TEST = "wromg !!";
            }

        System.out.println(TEST);
    }
}
