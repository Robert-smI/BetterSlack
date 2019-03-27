package sandbox.obserwator;

public interface Observable {

    void attache (Observer observer);
    void notifyObserver();

}
