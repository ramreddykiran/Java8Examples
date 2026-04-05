
public record Java14Record(String s, int i) {
    public static void main(String[] args) {
        Java14Record jp = new Java14Record("param1", 2);
        System.out.println(jp.s + " : " + jp.i);
    }
}
