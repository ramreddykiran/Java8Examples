package streamsexamples;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * @author kramreddy
 * create a map Map1 with <String, Integer> entries. create a result map Map2. 
 * Map2 should contain all the elements from Map1 where value >150
 * Map
 */
public class HashMapExample1 {
	public static void main(String[] args) {
		Map<String,Integer> sourceMap = createMap();
		
		System.out.println("sourceMap : "+sourceMap);
		Map<String,Integer> resultMap = sourceMap.entrySet().stream()
										.filter(entry1 -> entry1.getValue()>150)
										.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
										//.collect(Collectors.toMap(p -> p.getKey(), q -> q.getValue()));
		System.out.println("resultMap : "+resultMap);
	}

	private static HashMap<String, Integer> createMap() {
		HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
		hashMap.put("key1",200);
		hashMap.put("key10",111);
		hashMap.put("key9",20);
		hashMap.put("key2",90);
		hashMap.put("key4",120);
		hashMap.put("key3",150);
		hashMap.put("key7",110);
		hashMap.put("key66",133);
		hashMap.put("key21",190);
		hashMap.put("key8",180);
		hashMap.put("key11",170);
		hashMap.put("key21",144);
		hashMap.put("key12",155);
		hashMap.put("key5",132);
		
		return hashMap;
	}

}
