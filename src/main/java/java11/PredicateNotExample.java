package java11;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateNotExample {
    public static void main(String[] args) {
        String input = "this is a sample example to demonstrate predicate not method using letter count logic";
        Map<String, Long> letterCount = Arrays.stream(input.split(""))
                .filter(Predicate.not(String::isBlank))
               // .filter(s -> !s.isBlank()) //above code serves the same
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(letterCount);

    }

}
