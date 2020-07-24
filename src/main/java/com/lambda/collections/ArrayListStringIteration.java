package com.lambda.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListStringIteration {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("value1");
		list.add("value2");
		list.add("value5");
		list.add("value4");
		list.add("value3");
		System.out.println("before sort");
		
		list.forEach(i -> System.out.println(i));
		
		System.out.println("\n \nafter sort");
		
		Collections.sort(list);
		
		//list.forEach(i -> System.out.println(i));
		list.forEach(System.out::println);
	}

}
