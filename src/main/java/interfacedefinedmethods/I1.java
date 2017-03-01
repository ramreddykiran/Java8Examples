package interfacedefinedmethods;

//@FunctionalInterface //Gives compilation error. FunctionalInterface allows only 1 obstract method
public interface I1 {
	public void i1m1();
	public void i1m2();
	
	default void commonDefaultMethod(){
		System.out.println("defaultM1 method");
	}
	
	default void i1DefaultM2(){
		System.out.println("defaultM2 method");
	}
	
	static void i1StaticM1(){
		System.out.println("i1StaticM1 method");
	}
	
	 static void commonStaticMethod(){
			System.out.println("defaultM1 method");
	 }

}
