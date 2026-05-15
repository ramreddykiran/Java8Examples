package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCount {

    public static void main(String[] args) {
        CharCount cC = new CharCount();
        cC.charCount("hello how are you doing today hope you are good");
    }

    private void charCount(String input) {
        //approach-1
        Map<Character, Integer> countWay1 = new HashMap<>();
        for(char ch : input.toCharArray()) {
            countWay1.put(ch, countWay1.getOrDefault(ch, 0) + 1);
        }
        System.out.println("characters count " + countWay1);

        //approach-2
        Map<Character, Long> charCountWay2 =  input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("chatacter count " + charCountWay2);

        ////approach-3
        Map<String, Long> countWay3 = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), //s -> s
                        Collectors.counting()));
        System.out.println("letter count " + countWay3);


    }
}
