package interfaces.definedmethods;

public class DemoDefined {
	
	
	public static void main(String[] args) {
		I1 iobj1 = new SubClassDefined();
		iobj1.commonDefaultMethod(); // prints Subclass method as accessspecier is public
		iobj1.i1DefaultM2();
	    I1.commonStaticMethod(); //prints I1 method only.
		I1.i1StaticM1();
		I2.i2StaticM1();
	}
	

}
