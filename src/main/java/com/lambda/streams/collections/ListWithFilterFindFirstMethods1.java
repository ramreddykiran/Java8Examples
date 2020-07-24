package com.lambda.streams.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListWithFilterFindFirstMethods1 {
	public static void main(String[] args) {
		ListWithFilterFindFirstMethods1 obj = new ListWithFilterFindFirstMethods1();
		List<Integer> listI = Arrays.asList(1,2,3,5,4,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		obj.doubleFirstEvenNumGreaterThan3(listI);
	}

	private void doubleFirstEvenNumGreaterThan3(List<Integer> listI) {
		//using forEach
	/*
		int result =0;
		for(int i : listI) {
			if(i > 3 && i % 2 ==0) {
				result = i * 2;
				break;
			}
		}
	*/
	
	//using streams
		/*
		Optional<Integer> result =
				listI.stream()
		 	.filter(e -> e>3) //stream will add this condition to it but will not apply on data
		 	.filter(e -> e % 2 == 0) // same as above. add this on top of above condition but no action
		 	.map(e -> e * 2) // same as above
		 	.findFirst(); // when findFirst() is called.
		System.out.println(result); //it prints Optional[8] . Optional data type 
		System.out.println(result.get());// it prints 8 . Integer data type
		
		*/
		
		// refactor above logic
		Optional<Integer> result = listI.stream()
			.filter(ListWithFilterFindFirstMethods1 :: isGT3)
			.filter(ListWithFilterFindFirstMethods1::isEven)
			.map(ListWithFilterFindFirstMethods1::doubleIt)
			.findFirst();
		
		System.out.println(result); //it prints Optional[8] . Optional data type 
		System.out.println(result.get());// it prints 8 . Integer data type
	}
	
	private static boolean isGT3(Integer i) {
		return i > 3;
	}
	
	private static boolean isEven(Integer i) {
		return i % 2 == 0;
	}
	
	private static Integer doubleIt(Integer i) {
		return i * 2;
	}
}
