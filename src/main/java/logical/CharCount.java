package logical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CharCount {

    public static void main(String[] args) {
        CharCount cC = new CharCount();
        cC.charCount("hello How are YOU doing today hope you are good");
    }

    private void charCount(String input) {
        //approach-1
        Map<Character, Integer> countWay1 = new HashMap<>();
        for(char ch : input.toCharArray()) {
            countWay1.put(ch, countWay1.getOrDefault(ch, 0) + 1);
        }
        System.out.println("characters count " + countWay1);

        //approach-2
        Map<String, Long> charCountWay2 =  input.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .filter(Predicate.not(String::isBlank))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("chatacter count " + charCountWay2);

        ////approach-3
        Map<String, Long> countWay3 = Arrays.stream(input.split(""))
                .filter(Predicate.not(String::isBlank))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), //s -> s
                        Collectors.counting()));
        System.out.println("letter count " + countWay3);


    }
}
