package java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupMapByValueExample1 {

    public static void main(String[] args) {
        GroupMapByValueExample1 ge = new GroupMapByValueExample1();
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("a", 1); m1.put("a1", 91);
        m1.put("b", 21); m1.put("b1", 18);
        m1.put("c", 12); m1.put("c1", 12);
        m1.put("d", 14); m1.put("d1", 14);
        m1.put("e", 10); m1.put("e1", null);
        m1.put(null, 31); m1.put("f1", 44);
        m1.put("g", 19); m1.put("g1", 73);
        m1.put("e", 40); m1.put("e1", 25);
        m1.put("f", 21); m1.put("f1", 81);
        m1.put("g", 4); m1.put("g1", 1);
        ge.groupByValue(m1);

    }

    private void groupByValue(Map<String, Integer> map) {
        Map<Integer, List<String>> resultMap = map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                        ));
        System.out.println("result map group by value " + resultMap);

    }




}
