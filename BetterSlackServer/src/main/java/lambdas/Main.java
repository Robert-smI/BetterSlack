package lambdas;

public class Main {

    public static void main(String[] args) {

            CarSelectionView carSelectionView = new CarSelectionView();
            int userprice = 250000;
            int lowerYear = 2002;
            int upperrYear = 2015;

            carSelectionView.applyFilter(car -> {

                 return car.getPrice() > userprice &&
                    car.getProducedIn() >= lowerYear &&
                    car.getProducedIn() <upperrYear;
                    });

        System.out.println(carSelectionView);

    }


}
