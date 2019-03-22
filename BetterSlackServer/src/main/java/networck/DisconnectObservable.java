package networck;

public interface DisconnectObservable {
    void subscribe(DisconnectObserver observer);
    void unsuscribe(DisconnectObserver observer);
    void notifyDisconnected(ChatClient chatClient);
}
