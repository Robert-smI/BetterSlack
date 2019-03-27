package sandbox.obserwator;

public class MyTimer implements Observer {

    private boolean running;
    private Thread countingThread;

    void start() {
        if (running) {
            return;
        }

        countingThread = new Thread(() -> {
            running = true;
            int counter = 0;
            while (running) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(++counter);
            }
            System.out.println("Counter thread is end");
        });
        countingThread.start();
    }

    public void join() throws InterruptedException {
        countingThread.join();
    }

    public boolean isRunning() {
        return running;
    }


    @Override
    public void exitRequest() {
        running = false;
    }
}
