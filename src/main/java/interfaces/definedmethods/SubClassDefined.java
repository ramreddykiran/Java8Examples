package interfaces.definedmethods;

public class SubClassDefined implements I1,I2{

	@Override
	public void i1m1() {
		System.out.println("i1m1 method in SubClassDefined");
	}

	@Override
	public void i1m2() {
		System.out.println("i1m2 method in SubClassDefined");
	}

	@Override
	public void i2m1() {
		System.out.println("i2m1 method in SubClassDefined");
	}

	@Override
	public void i2m2() {
		System.out.println("i2m1 method in SubClassDefined");
	}
	
	public void commonDefaultMethod(){
		System.out.println("overriden commonDefaultMethod in SubClassDefined");
	}
	
	static void commonStaticMethod(){
		System.out.println("commonStatic Method overriden in SubClassDefined");
    }
	

}
