import commands.Message;

public interface NetworkBasedChatClient extends ChatClient{

    void connect(String ip, int port);
    void disconnect();
    void sendMessageCommand (Message message);
    boolean isOnline();
    //  outdated method replaced by sendMessageCommand
    void sendMessage(String txt);
}
