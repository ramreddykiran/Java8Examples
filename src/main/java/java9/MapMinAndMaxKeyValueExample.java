package java9;

import java.util.HashMap;
import java.util.Map;

public class MapMinAndMaxKeyValueExample {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10); map.put(2, 20); map.put(3, 30); map.put(4, 25); map.put(5, 11); map.put(6, 15);
        map.put(31, null); map.put(12, 20); map.put(3, null); map.put(null, 23); map.put(null, null); map.put(16, 35);
        MapMinAndMaxKeyValueExample mKVE = new MapMinAndMaxKeyValueExample();
        mKVE.maxValue(map);
        mKVE.maxKey(map);
        mKVE.minKey(map);
        mKVE.minValue(map);

    }

    private void minValue(Map<Integer, Integer> map) {
        map.entrySet().stream()
                .filter(e -> null != e.getValue())
                .min(Map.Entry.comparingByValue())
                .ifPresentOrElse(
                        e -> System.out.println("min value = " + e.getValue()),
                        () -> System.out.println("no minimum value found")
                );
    }

    private void minKey(Map<Integer, Integer> map) {
        map.entrySet().stream()
                .filter(e -> null != e.getKey())
                .min(Map.Entry.comparingByKey())
                .ifPresentOrElse(
                        e -> System.out.println("minimum key = " + e.getKey()),
                        () -> System.out.println("no minumum key found")
                );
    }

    private void maxKey(Map<Integer, Integer> map) {
        map.entrySet().stream()
                .filter(e -> null != e.getKey())
                .max(Map.Entry.comparingByKey())
                .ifPresentOrElse(
                        e -> System.out.println("max key = " + e.getKey()),
                        () -> System.out.println("no max key found")
                );
    }

    private void maxValue(Map<Integer, Integer> map) {
        map.entrySet().stream()
                .filter(e -> null != e.getValue())
                .max(Map.Entry.comparingByValue())
                .ifPresentOrElse(
                        e -> System.out.println("max value = " + e.getValue()),
                        () -> System.out.println("no max value found")
                );
    }


}
