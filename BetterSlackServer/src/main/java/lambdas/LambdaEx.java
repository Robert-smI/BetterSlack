package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaEx {

    public static void main(String[] args) {

        List<String> toUpperCase = Arrays.asList("Lorem",
                "ipsum", "dolor", "sit amet",
                "consectetur",
                "adipiscing elit");

      //  System.out.println(toUpper(toUpperCase));
        System.out.println(String.join(", ", toUpper(toUpperCase)));

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<String> toFilter = Arrays.asList("Lorem",
                "ipsum", "dolor", "sit amet",
                "consectetur", "arg",
                "adipiscing elit", "arr");


        System.out.println(getString(ints));

    }
        private static List<String>toUpper(List<String> list){
            return list.stream()
                    .map((s -> s.toUpperCase()))
                    .collect(Collectors.toList());
        }

    private static double average(List<Integer> list) {
          return  list.stream()
                    .mapToInt(x->x)
                    .average().getAsDouble();
    }

    private static List<String> search(List<String> list) {
      return  list.stream()
                .filter(s -> s.startsWith("a") && s.length()==3)
                .collect(Collectors.toList());
    }


    private static String getString(List<Integer> list) {
      return  list.stream()
                .map(x->{
                    if(x%2==0){
                        return "e" + x;
                    }
                    else {
                        return "o" +x;
                    }

        }).collect(Collectors.joining(", "));

    }




}
