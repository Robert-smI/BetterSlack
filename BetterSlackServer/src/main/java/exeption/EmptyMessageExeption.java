package exeption;

public class EmptyMessageExeption extends RuntimeException {
    public EmptyMessageExeption() {
        super("message cannot by empty");
    }
}
