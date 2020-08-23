package com.lambda.streams.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class ListWithFilterAndCollectMethods1 {
	public static void main(String[] args) {
		ListWithFilterAndCollectMethods1 l1= new ListWithFilterAndCollectMethods1();
		List<Integer> listI = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		System.out.println("collecting odd numbers to a  list");
		l1.collectOddNumbersToList(listI);
		System.out.println("collecting double of odd numbers to a set");
		l1.collectDoubleOfOddNumbersToSet(listI);
	}

	private void collectOddNumbersToList(List<Integer> listI) {
		
		//wrong way to do : 
		/*
		 List<Integer> oddNumbers = new ArrayList<>();
		 
		 listI.stream()
			.filter(e -> e%2 ==1)
			//.forEach(e -> oddNumbers.add(e));
			.forEach(oddNumbers::add);
		*/
		//mutability is ok, sharing is OK. shared mutability is not recommended.
		
		//right way
		List<Integer> oddNumbers = 
				listI.stream()
					.filter(e -> e%2 == 1)
					.collect(toList());
		
		System.out.println(oddNumbers);
	}
	
	private void collectDoubleOfOddNumbersToSet(List<Integer> listI) {
		Set<Integer> doubleOfOddNumbers =listI.stream()
			 .filter(e -> e%2 ==1)
			 .map(e -> e * 2)
			 .collect(toSet());
		System.out.println(doubleOfOddNumbers);
		
		
	}

}
