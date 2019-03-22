package networck;

public interface ChatServer extends DisconnectObserver {

    void start (int port);
    void shutdown();
    boolean isOnline();
}
