public interface NetworkBasedChatClient extends ChatClient{

    void connect(String ip, int port);
    void disconnect();
    void sendMessage(String txt);
    boolean isOnline();
}
