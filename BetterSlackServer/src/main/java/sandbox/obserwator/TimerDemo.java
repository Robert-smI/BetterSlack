package sandbox.obserwator;

import java.util.Scanner;

public class TimerDemo {

    public static void main(String[] args) {

        while (true){
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")){
                break;
            }
        }

    }



}
