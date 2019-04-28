import commands.ChatCommand;

public interface UserInputProvider {
    ChatCommand getUserInput();
    String getUserInputSimple ();
}
