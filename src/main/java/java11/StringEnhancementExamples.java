package java11;

public class StringEnhancementExamples {

    public static void main(String[] args) {
        StringEnhancementExamples se = new StringEnhancementExamples();
        se.stringExamples();
    }

    //isBlank(), strip(), lines(), repeat(int)
    private void stringExamples() {
        String s1 = "  ";
        //String s1 = null; // throws NullPointerException
        if(s1.isBlank()) {
            System.out.println("blank string s1 start:" + s1 + "s1 end");
        }

        String linesString = "this\nis\nthe\nlines\nseparated\nstring";
        linesString.lines().forEach(System.out::println);


        String s2 = "         abc def  ghi   ";
        s2 = s2.strip();
        System.out.println("strip string s2 start: "+s2+" s2 end");


        String s3 = "abc";
        System.out.println("repeating s3 3 times: "+s3.repeat(3));
    }
}
