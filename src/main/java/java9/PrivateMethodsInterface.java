package java9;

@FunctionalInterface
public interface PrivateMethodsInterface {

    void abstractM();

    private void privateM1() {
        System.out.println("private method-1");
    }

    private void privateM2() {
        privateM1();
    }

    private static void privateStaticM1() {

    }

    private static void privateStaticM2() {

    }


}
