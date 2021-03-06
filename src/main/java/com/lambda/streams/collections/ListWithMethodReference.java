package com.lambda.streams.collections;

import java.util.Arrays;
import java.util.List;

public class ListWithMethodReference {

	public static void main(String[] args) {
		ListWithMethodReference l1 = new ListWithMethodReference();
		List<Integer> listI = Arrays.asList(11,22,33,43,55,66,77,88,99,180);
		l1.printList(listI);
		l1.limitTheListTo5(listI); //it will limit the list to first 5 elements
		l1.convertToStringAndPrint(listI);
		l1.calculateSum(listI);
		l1.covertToStringAndConcat(listI);
	
	}

	private void printList(List<Integer> listI) {
		System.out.println("printing values");
		listI.stream()
		// .forEach((Integer e) ->System.out.println(e));
		// .forEach((e) ->System.out.println(e));
		 //.forEach(e -> System.out.println(e));
		 .forEach(System.out::print); //:: is a Method Reference operator
		
	}
	
	private void limitTheListTo5(List<Integer> listI) {
		System.out.println("\nprinting values with limit");
		listI.stream()
			.limit(5)
			.forEach(System.out::println);
	}

	private void convertToStringAndPrint(List<Integer> listI) {
		System.out.println("\nconverting to string printing values");
		listI.stream()
			//.map(e -> Integer.toString(e)) //Or
			//.map(e -> e.toString())       //Or
		    //.map(e -> String.valueOf(e))  //Or
		    .map(String::valueOf)
			.forEach(System.out::print);
		
	}
	
	private void calculateSum(List<Integer> listI) {
		System.out.println("\n calculating sum");
		Integer total = listI.stream()
							//.reduce(0, (value,e) -> Integer.sum(value, e)));
							.reduce(0, Integer::sum);
		System.out.println(total);
	}
	
	private void covertToStringAndConcat(List<Integer> listI) {
		System.out.println("converting each value to String and concating");
		String result = listI.stream()
							.map(String::valueOf)
							// .reduce("", (str1,str2) -> str1.concat(str2));
							.reduce("", String::concat);
		System.out.println(result);
	}
}
