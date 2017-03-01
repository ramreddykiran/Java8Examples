package com.lambda.addition;

public class AddInt {
	public void add2(){
		Add2Interface iobj1 = (i1,i2) -> i1+i2;
		System.out.println("addition of 2 int "+iobj1.add(4, 10));
	}
	
	public void add3(){
		Add3Interface iobj1 = (i1,i2,i3) -> System.out.println("addition of 3 int "+(i1+i2+i3));
		iobj1.add(10, 12, 13);
	}
	
	public static void main(String[] args) {
		AddInt addInt = new AddInt();
		addInt.add3();
		addInt.add2();
	/*	Add2Interface add2Int = (i1, i2) -> (i1+i2);
		System.out.println(add2Int.add(3, 2));
		
		Add3Interface add3Int = (i1, i2, i3) -> System.out.println(i1+i2+i3);
		add3Int.add(10, 22, 33);*/
		}

}
