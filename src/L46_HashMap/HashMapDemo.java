package L46_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// put
		map.put("India", 10);
		map.put("US", 20);
		map.put("UK", 5);
		map.put("Aus", 3);

		System.out.println(map);

		// get
		System.out.println(map.get("US"));
		System.out.println(map.get("China"));

		// containsKey
		System.out.println(map.containsKey("China"));
		System.out.println(map.containsKey("US"));

		// remove
		System.out.println(map.remove("US"));
		System.out.println(map.remove("China"));
		System.out.println(map);

		// print

		// way 1
		Set<String> keys = map.keySet();

		for (String key : keys) {
			System.out.println(key + " -> " + map.get(key));
		}

		// way 2
		for (String key : map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}

		// way 3
		ArrayList<String> list = new ArrayList<>(map.keySet());

		for (String key : list) {
			System.out.println(key + " -> " + map.get(key));
		}

	}
}
