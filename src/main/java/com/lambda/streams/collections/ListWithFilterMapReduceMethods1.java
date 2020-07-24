package com.lambda.streams.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListWithFilterMapReduceMethods1 {
	public static void main(String[] args) {
		ListWithFilterMapReduceMethods1 l1 = new ListWithFilterMapReduceMethods1();
		List<Integer> listI = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		l1.doubleEvenNumbersAndSum(listI);
	}

	private void doubleEvenNumbersAndSum(List<Integer> listI) {
		
		//normal reduce operation
		/*
		Integer total = listI.stream()
			 .filter(e -> e % 2 == 0)
			 .map(e -> e * 2)
			 .reduce(0, (carry,e) -> carry + e);
		*/
		
		
		
		//normal reduce operation
		/*
		 Optional<Integer> total = listI.stream()
				.filter(e -> e % 2 ==0)
				.map(e -> e * 2)
				.reduce(Integer::sum);
				*/ 
				//returns Optional<Integer>
		
		//specialized reduce operation
		
		 Integer total = listI.stream()
				.filter(e -> e%2 ==0)
				.mapToInt(e -> e*2)
				.sum(); 
				  //returns Integer
		System.out.println(total);
	}

}
