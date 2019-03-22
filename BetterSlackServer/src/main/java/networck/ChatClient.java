package networck;

public interface ChatClient extends DisconnectObservable {
    void sendMessage(String message);
    void disconnect();
    boolean isOnline();
}
