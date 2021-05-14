package L47_HashMapImplementation;

public class Client {

	public static void main(String[] args) {

		HashMap map = new HashMap();
		
		map.put("A", 10);
		map.put("B", 30);
		map.put("C", 20);
		map.put("D", 80);
		map.put("E", 60);		
		map.put("F", 70);		
		map.put("G", 20);		
		map.put("H", 10);		
		map.put("I", 70);		
		System.out.println(map);
		
		map.put("A", 100);
		System.out.println(map);
		
		System.out.println(map.get("B"));
		System.out.println(map.get("F"));
		
		System.out.println(map.containsKey("B"));
		System.out.println(map.containsKey("F"));
		
		System.out.println(map.remove("B")) ;
		System.out.println(map);
		
	
	}
}
