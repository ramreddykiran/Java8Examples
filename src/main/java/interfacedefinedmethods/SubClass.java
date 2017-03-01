package interfacedefinedmethods;

public class SubClass implements I1,I2{

	@Override
	public void i1m1() {
		System.out.println("i1m1 method");
	}

	@Override
	public void i1m2() {
		System.out.println("i1m2 method");
	}

	@Override
	public void i2m1() {
		System.out.println("i2m1 method");
	}

	@Override
	public void i2m2() {
		System.out.println("i2m1 method");
	}
	
	public void commonDefaultMethod(){
		System.out.println("overriden commonDefaultMethod in SubClass");
	}
	

}
