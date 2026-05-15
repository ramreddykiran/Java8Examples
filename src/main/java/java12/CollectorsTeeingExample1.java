package java12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsTeeingExample1 {

    public static void main(String[] args) {
        CollectorsTeeingExample1 cte = new CollectorsTeeingExample1();
        cte.calculateAverage(Arrays.asList(2,7,5,10,2,5));
    }

    private void calculateAverage(List<Integer> list) {
        double averageValue = list.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(Integer::intValue),
                        Collectors.counting(),
                        (sum, count) -> sum / (double) count
                ));
        System.out.println("average = " + averageValue);
    }
}
