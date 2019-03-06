package lambdas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarSelectionView {

    private int availableCars;
    private List<Car> originalList;
    private List<Car> displayedCars;

    public CarSelectionView() {
        displayedCars = new ArrayList<>();
        Random random = new Random();
        originalList = Arrays.asList(
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Tesla", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Ferrari", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Tesla", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Fiat", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Ferrari", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Ferrari", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Fiat", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Tesla", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Fiat", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Fiat", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Fiat", (random.nextDouble() * 1000000) + 1000, random.nextInt()),
                new Car("Mercedes", (random.nextDouble() * 1000000) + 1000, random.nextInt())
        );
    }

    public <T> void applyFilter(Predicate<Car> filter) {

      displayedCars = originalList.stream().filter(filter).collect(Collectors.toList());
      availableCars = (int) originalList.stream().filter(filter).count();

        displayedCars.forEach(car -> System.out.println(car));
    }


}
