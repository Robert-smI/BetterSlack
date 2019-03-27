package exeption;

public class EmptyMessageExeption extends RuntimeException {
    public EmptyMessageExeption() {
        super("Message cannot be empty!");
    }
}
