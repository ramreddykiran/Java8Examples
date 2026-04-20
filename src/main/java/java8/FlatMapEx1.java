package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlatMapEx1 {

    void charactersCount(List<String> words) {
        Map<String, Long> characters = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                //.filter(Predicate.not(String::isBlank)) // Predicate.not() introduced in java11
                .filter(c -> !c.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
               // .collect(Collectors.toList());
        System.out.println(characters);

    }

    public static void main(String[] args) {
        FlatMapEx1 flatMapEx1 = new FlatMapEx1();
        flatMapEx1.charactersCount(Arrays.asList("Hello", "How Are You"));
    }
}
