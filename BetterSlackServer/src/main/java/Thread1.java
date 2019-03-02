public class Thread1 implements Runnable {

    private final String name;

    public Thread1(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Hello from Thread 1" + name);
    }
}
