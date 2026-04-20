package java9;

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

        List<String> l = List.of("abc", "def", "ghi", "abc","abc", "def1", "ghi11", "abc12","abc2", "def2", "ghi2", "abc3","abc4", "def3", "ghi3", "abc5"); // immutable list, null not allowed
       // l.add("jkl");  // run time error. immutable list
        System.out.println("list = " + l);
    }

    void setEx() {
        Set<Integer> s = Set.of(1,2,4,3); // immutable set can not add duplicates, null values
        System.out.println("set = " + s);
    }

    void mapEx() {
        Map<String, String> m = Map.of("one", "1", "two", "2", "three", "3",
                "four", "4", "five", "4"); //immutable map . can not add duplicate keys, null keys
        //m.put("seven","7"); //can not add entries later. can not modify.
        System.out.println("map = " + m);
    }

    public static void main(String[] arg) {
        Java9CollectionsExamples ce = new Java9CollectionsExamples();
        ce.listEx();
        ce.setEx();
        ce.mapEx();

    }
}
