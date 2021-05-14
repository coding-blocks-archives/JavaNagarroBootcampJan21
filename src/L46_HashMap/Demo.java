package L46_HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class Demo {

	public static void main(String[] args) {
	
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>() ;
		
		map.put(10, new ArrayList<>()) ;
		map.put(20, new ArrayList<>()) ;
		
		System.out.println(map);
		
		map.get(10).add(100) ;
		map.get(10).add(200) ;
		
		System.out.println(map);
		
		map.get(20).add(300) ;
		map.get(20).add(400) ;
		
		System.out.println(map);
		

	}

}
