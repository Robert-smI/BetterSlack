import commands.ChatCommand;

public interface UserInputProvider {
    ChatCommand getUserInput();
    public String getUserInputSimple ();
}
