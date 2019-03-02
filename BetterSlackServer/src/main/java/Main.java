public class Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1("thread"));
        Thread thread2 = new Thread(new Thread1("thread"));


        thread1.start();
        thread2.start();


    }


}
