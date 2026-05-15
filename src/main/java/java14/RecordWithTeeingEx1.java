package java14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecordWithTeeingEx1 {

    record MinMax(int min, int max) {}

    public static void main(String[] args) {
        RecordWithTeeingEx1 rwt = new RecordWithTeeingEx1();
        rwt.getMinMaxFromList(Arrays.asList(8,3,4,2,12,33,15,21,45,31,18));
    }

    private void getMinMaxFromList(List<Integer> list) {
        MinMax minMax = list.stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compareTo),
                        Collectors.maxBy(Integer::compareTo),
                        (min, max) -> new MinMax(min.get(), max.get())
                ));
        System.out.println("min value = " + minMax.min + " max value = " + minMax.max);
    }
}
