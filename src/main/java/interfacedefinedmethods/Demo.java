package interfacedefinedmethods;

public class Demo {
	
	public void method1(){
		I1.commonStaticMethod(); 
	}
	
	public static void main(String[] args) {
		I1 iobj1 = new SubClass();
		iobj1.commonDefaultMethod();
		iobj1.i1DefaultM2();
		I1.i1StaticM1();
	}

}
