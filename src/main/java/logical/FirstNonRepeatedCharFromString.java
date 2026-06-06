package logical;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Both Approach-1 and Approach-2
 * TimeComplexity O(n) ; SpaceComplexity O(n)
 */
public class FirstNonRepeatedCharFromString {

    public static void main(String[] args) {
        FirstNonRepeatedCharFromString f = new FirstNonRepeatedCharFromString();
        f.approach1("swiss wi");
        f.approach2("swiss wi");
        f.approach3("First Word is five");
    }

    private void approach2(String input) {
        System.out.println("Approach-2 : ");
        Map<Character, Long> charCountMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )); //return char count LinkedHashMap<Character, Long> here
        Character nonRepeatedChar = charCountMap.entrySet()
                .stream()
                .filter(e -> Character.isLetter(e.getKey()))
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("non repeated char is " + nonRepeatedChar);
    }

    private void approach3(String input) {
        System.out.println("approach-3");
        Map<String, Long> letterCountMap = Arrays.stream(input.split(""))
                .filter(Predicate.not(String::isBlank))
                .filter(s -> s.matches("[a-zA-Z]+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )
                );
        String outputLetter = letterCountMap.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("first unique letter is " + outputLetter);
    }

    private void approach1(String input) {
        System.out.println("Approach-1 : ");
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        char nonRepeatedChar = '\0';
        for(char ch:input.toCharArray()) {
            if(Character.isLetter(ch)) {
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if(entry.getValue() == 1) {
                nonRepeatedChar = entry.getKey();
                break;
            }
        }
        if('\0' != nonRepeatedChar) {
            System.out.println("non repeated char is " + nonRepeatedChar);
        } else {
            System.out.println("no non repeated char found");
        }
    }
}
