package sandbox.obserwator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class InputProvider implements Observable {

        List <Observer> observers = new ArrayList<>();

        private final Scanner scanner = new Scanner(System.in);

        public String getInput() {
            String input = scanner.nextLine();
            if(input.equals("q")) {
                notifyObserver();
            }
            return input;
        }


        @Override
        public void attache(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void notifyObserver() {

            observers.forEach(observer -> observer.exitRequest());
//            for (Observer observer : observers
//                 ) {
//                observer.exitRequest();
            }

    }
