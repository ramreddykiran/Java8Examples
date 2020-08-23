package com.lambda.addition;

public class AddInt {
	public void add2(){
		Add2Interface iobj1 = (i1,i2) -> i1+i2;
		System.out.println("addition of 2 int "+iobj1.add(4, 10));
	}
	
	public void add3Impl1(){
		Add3Interface iobj1 = (i1,i2,i3) -> System.out.println("addition of 3 int "+(i1+i2+i3));
		iobj1.add(10, 12, 13);
	}
	
	public void add3Impl2() {
		Add3Interface iobj1 = (i1,i2,i3) -> {
			int sum = i1+i2+i3;
			System.out.println("sum of 3 integers = "+sum);
		};
		iobj1.add(100, 200, 3);
	}
	
	public static void main(String[] args) {
		AddInt addInt = new AddInt();
		addInt.add3Impl1();
		addInt.add3Impl2();
		addInt.add2();
	/*	Add2Interface add2Int = (i1, i2) -> (i1+i2);
		System.out.println(add2Int.add(3, 2));
		
		Add3Interface add3Int = (i1, i2, i3) -> System.out.println(i1+i2+i3);
		add3Int.add(10, 22, 33);*/
		}

}
