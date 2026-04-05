public class Java14Examples {

    public static void main(String[] args) {
        Java14Examples je = new Java14Examples();
        je.instanceofEx(null);
        je.instanceofEx("input");
        je.instanceofEx(212);
    }

    private void instanceofEx(Object obj) {
        if(obj instanceof String s) {
            System.out.println("s length is " + s.length());
        } else {
            System.out.println("not a String type");
        }
    }
}
