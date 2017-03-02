package com.lambda.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HashMapKeysValuesSort {

	public static void main(String[] args) {
		HashMapKeysValuesSort hashMapSort = new HashMapKeysValuesSort();
		Map<Integer, String> hashMap = hashMapSort.createHashMap();
		System.out.println("before sorting " + hashMap);
		System.out.println("sorting keys map " + new TreeMap<Integer, String>(hashMap));

		List<Map.Entry<Integer, String>> entries = new ArrayList<Map.Entry<Integer, String>>(hashMap.entrySet());

		// hashMapSort.sortUsingFormalComparator(entries);
		hashMapSort.sortUsingLamdaComparator(entries);
	}

	private void sortUsingLamdaComparator(List<Entry<Integer, String>> entries) {
		Collections.sort(entries, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
	
		Map<Integer, String> sortedValuesMap = new LinkedHashMap<Integer, String>();
		
		entries.forEach(entry->sortedValuesMap.put(entry.getKey(), entry.getValue()));
		
		/*for (Map.Entry<Integer, String> entry : entries) {
			sortedValuesMap.put(entry.getKey(), entry.getValue());
		}*/
		System.out.println("sorted values map " + sortedValuesMap);
	}

	private void sortUsingFormalComparator(List<Map.Entry<Integer, String>> entries) {
		Collections.sort(entries, new Comparator<Map.Entry<Integer, String>>() {
			@Override
			public int compare(Map.Entry<Integer, String> e1,
					Map.Entry<Integer, String> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});

		Map<Integer, String> sortedValuesMap = new LinkedHashMap<Integer, String>();
		for (Map.Entry<Integer, String> entry : entries) {
			sortedValuesMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println("sorted values map " + sortedValuesMap);
	}

	private Map<Integer, String> createHashMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "value1");
		map.put(2, "value2");
		map.put(5, "value5");
		map.put(4, "value1");
		map.put(10, "value6");
		map.put(2, "value7");
		map.put(11, "value4");
		map.put(3, "value3");
		return map;
	}

}
