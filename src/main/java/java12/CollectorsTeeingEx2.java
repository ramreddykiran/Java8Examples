package java12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsTeeingEx2 {

    class MinMax {
        int min;
        int max;
        MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "min = " + this.min + " max = " + this.max;
        }
    }

    public static void main(String[] args) {
        CollectorsTeeingEx2 cte2 = new CollectorsTeeingEx2();
        cte2.calculateMinMaxFromList(Arrays.asList(10,3,5,20,11,31,9,28,21,2,15));
    }

    private void calculateMinMaxFromList(List<Integer> list) {
        //MinMax minMax = new MinMax()
        MinMax minMax = list.stream()
                .collect(Collectors.teeing(
                     Collectors.minBy(Integer::compare),
                        Collectors.maxBy(Integer::compare),
                        (min, max) -> new MinMax(min.get(), max.get())
                ));
        System.out.println(minMax);
    }
}
