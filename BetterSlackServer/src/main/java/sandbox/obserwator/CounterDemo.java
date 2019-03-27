package sandbox.obserwator;

public class CounterDemo {


    public static void main(String[] args) {

        Thread countThread = new Thread(() -> {

            for (int i = 0; ; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i+1);
            }
        });
        countThread.start();
    }


}
