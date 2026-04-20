package interfaces.definedmethods;

public interface ChildInterface extends I1, I2 {
    @Override
    public default void commonDefaultMethod(){
        I1.super.commonDefaultMethod();
        I2.super.commonDefaultMethod();

        //System.out.println("overriden commonDefaultMethod in ChildInterface");
    }
}
