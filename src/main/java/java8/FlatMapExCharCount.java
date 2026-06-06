package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlatMapExCharCount {

    void charactersCount(List<String> words) {
        Map<String, Long> characters = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                //.filter(Predicate.not(String::isBlank)) // Predicate.not() introduced in java11
                .filter(c -> !c.isBlank())
                .map(String ::toUpperCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
               // .collect(Collectors.toList());
        System.out.println(characters);

    }

    public static void main(String[] args) {
        FlatMapExCharCount flatMapEx1 = new FlatMapExCharCount();
        flatMapEx1.charactersCount(Arrays.asList("Hello", "How Are You"));
    }
}
