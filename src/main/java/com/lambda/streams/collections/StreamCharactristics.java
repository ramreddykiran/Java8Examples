package com.lambda.streams.collections;

import java.util.Arrays;
import java.util.List;

public class StreamCharactristics {
	
	public static void main(String[] args) {
		//StreamCharactristics sc = new StreamCharactristics();
		List<Integer> l1 = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		l1.stream()
			.filter(e -> e%2 == 0)
			.forEach(System.out::println); //2,4,2,4
			//Stream is sized, ordered, non-distinct, non-sorted
		
		System.out.println("applying sorted ");
		l1.stream()
			.filter(e -> e%2 ==0)
			.sorted()
			.forEach(System.out::println); //2,2,4,4,
			//Stream is sized, ordered, non-distinct, sorted
		
		System.out.println("applying distinct ");
		l1.stream()
			.filter(e -> e%2 ==0)
			.distinct()
			.forEach(System.out::println);//2,4
			//Stream is sized, ordered, distinct, non-sorted
		
		System.out.println("applying multiple methods ");
		Arrays.asList(9,8,1,3,2,6,4,5,8,5,3,4,1,2,5,9).stream()
			.filter(e -> e%2==0)
			.sorted()
			.distinct()
			.forEach(System.out::println);

	}

}
