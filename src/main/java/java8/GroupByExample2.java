package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample2 {
    public static void main(String[] args) {
        GroupByExample2 ge = new GroupByExample2();
        groupByListOfStringsLength();
    }

    private static void groupByListOfStringsLength() {
        List<String> list = Arrays.asList("this", "is", "a", "sample", "list", "of", "strings", "Example", "array",
                "adding", "some", "words", "to", "this", "list");
        Map<Integer, List<String>> groupByLengthMap = list.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("group list by length " + groupByLengthMap);
    }
}
