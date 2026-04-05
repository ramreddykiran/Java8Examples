package logical;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
print only unique elements from array.
if any element appears more than 1 time, ignore it
ex: input {1,2,3,4,2,1,0,-1,-2,-4,-4}
    output = [3,4,0,-1,-2]
 */
public class UniqueArrayElements {

    public static void main(String[] args) {
        UniqueArrayElements uae = new UniqueArrayElements();
        uae.java5Approach();
        uae.java8Approach();
        uae.java8StreamsApproach();
    }

    private void java5Approach() {
        int[] a = {1,2,3,4,2,1,0,-1,-2,-4,-4};
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i : a) {
            if(countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }
        System.out.println("java5 | countMap = " + countMap);
        List<Integer> uniqueElements = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == 1) {
                uniqueElements.add(entry.getKey());
            }
        }
        System.out.println("java5 | unique elements = " + uniqueElements);

    }

    private void java8Approach() {
        int a[] = {1,2,3,4,2,1,0,-1,-2,-4,-4};
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i : a) {
            //getOrDefault introduced in java 8
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        System.out.println("Java-8 | countMap = " +countMap);

        List<Integer> uniqueElements = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == 1) {
                uniqueElements.add(entry.getKey());
            }
        }
        System.out.println("java 8 | unique elements = " +uniqueElements);

    }

    private void java8StreamsApproach() {
        int a[] = {1,2,3,4,2,1,0,-1,-2,-4,-4};
        List<Integer> uniqueElements = Arrays.stream(a) //converts int[] to IntStream
                .boxed() // converts primitive int to Integer object. because groupingBy works with Objects.not primitives
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                /* the above step collect elements into Map<Integer, Long>
                * Function.identity() always returns its input argument. GroupBy the element itself
                * Collectors.counting() counts the number of elements in each group*/
                .entrySet().stream()
                .filter(e -> e.getValue() ==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()); //Java 8 modifiable list. can add or delete elements
                //.toList(); //Java 16 | unmodifiable list. throws exception if add/delete element

        System.out.println("java 8 steams | uniqueElements = " + uniqueElements);
    }

}
