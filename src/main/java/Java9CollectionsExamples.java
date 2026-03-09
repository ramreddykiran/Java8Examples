import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * List.of(), Set.of(), Map.of() Demo
 */
public class Java9CollectionsExamples {

    void listEx() {
        /*List<String> l1 = Arrays.asList("ab","ac","ad","ab",null,"ad",null); //null allowed
        System.out.println("list1 = " + l1); */

        List<String> l = List.of("abc", "def", "ghi", null, "abc"); // immutable list, null not allowed
       // l.add("jkl");  // run time error. immutable list
        System.out.println("list = " + l);
    }

    void setEx() {
        Set<Integer> s = Set.of(1,2,4,3,1,3); // immutable set can not add duplicates
        System.out.println("set = " + s);
    }

    void mapEx() {
        Map<String, String> m = Map.of("one", "1", "two", "2", "three", "3",
                "two", "1"); //immutable map . can not add duplicate keys
        System.out.println("map = " + m);
    }

    public static void main(String[] arg) {
        Java9CollectionsExamples ce = new Java9CollectionsExamples();
        ce.listEx();
        ce.setEx();
        ce.mapEx();

    }
}
