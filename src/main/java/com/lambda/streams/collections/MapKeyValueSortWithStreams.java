package com.lambda.streams.collections;

import java.util.*;
import java.util.Map.Entry;

import static java.util.stream.Collectors.toMap;

public class MapKeyValueSortWithStreams {

	public static void main(String[] args) {
		MapKeyValueSortWithStreams obj = new MapKeyValueSortWithStreams();
		Map<Integer, String> hashMap = obj.createHashMap();
		System.out.println("before sorting "+ hashMap);
		System.out.println("key based sorting " +new TreeMap<Integer, String>(hashMap));

		System.out.println("before sorting "+ hashMap);
		obj.valueSortingWithStreams(hashMap);

		System.out.println("before sorting "+ hashMap);
		obj.valueSortingWithLambdaAndStreams(hashMap);

	}
	
	private void valueSortingWithLambdaAndStreams(Map<Integer, String> hashMap) {
		hashMap.values().removeIf(Objects::isNull); //removes the null value entries from Map
		List<Map.Entry<Integer, String>> entries = new ArrayList<Map.Entry<Integer,String>>(hashMap.entrySet());

		Collections.sort(entries, (e1,e2)->e1.getValue().compareTo(e2.getValue()));
		Map<Integer, String> resultMap =
				entries.stream()
						//.filter(e -> null!=e.getValue()) //null value entries already removed above
						.collect(
								toMap(Entry::getKey, 	  // keyMapper
									  Entry::getValue,    // valueMapper
									  (a,b) ->a,		 //mergeFunction 
									  () -> new LinkedHashMap<>() //mapSupplier 
									  //	LinkedHashMap::new 
						));
		System.out.println("after value sorting with lambda and streams "+ resultMap);
	}
	
	private void valueSortingWithStreams(Map<Integer, String> hashMap) {
		LinkedHashMap<Integer,String> resultMap = 
				hashMap.entrySet()
						.stream()
						.filter(e -> null != e.getValue())
						//.filter(e -> Optional.ofNullable(e.getValue()).isPresent())
						//.sorted(Entry.comparingByValue()) // applies comparator logic on vlaues comparision
						.sorted(Entry.comparingByValue(Comparator.reverseOrder())) //sort in reverse order
						.collect(
								toMap(Entry::getKey, 		//keyMapper
									  Entry::getValue, 		//valueMapper
									  (first,second)->second, //mergeFunction
									  LinkedHashMap::new			//mapSupplier
						));
				
		System.out.println("after value sorting only with streams "+ resultMap);

	}
	
	private Map<Integer, String> createHashMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(31, "value3");
		map.put(1, null);
		map.put(12, null);
		map.put(12, "value1");
		map.put(15, "value5");
		map.put(11, "value4");
		map.put(21, "value2");
		map.put(4, "value1");
		map.put(20, "value6");
		map.put(2, "value7");
		//map.put(null, "value7");
		return map;
	}

}

/*
 More explanation
 https://stackoverflow.com/questions/56307682/convert-list-to-map-using-java-8
 In Java-8 there are three overloaded toMap method, the above one is with 4 Parameters which is

public static <T,K,U,M extends Map<K,U>> Collector<T,?,M> toMap(Function<? super T,? extends K> keyMapper,
                                                            Function<? super T,? extends U> valueMapper,
                                                            BinaryOperator<U> mergeFunction,
                                                            Supplier<M> mapSupplier)
 
Parameters:

keyMapper - a mapping function to produce keys

valueMapper - a mapping function to produce values

mergeFunction -if 2 values have same key, it keeps the 1st or 2nd value for the key, ignores the other one.
			if we do not use merge function, toMap() will through IllegalStateException

mapSupplier - a function which returns a new, empty Map into which the results will be inserted



 
 */
