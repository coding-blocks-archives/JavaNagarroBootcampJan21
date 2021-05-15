package L47_QPS;

public class HammingDistance {

	public static void main(String[] args) {
		
		int x = 1 ;
		int y = 4 ;
		
		int xor = x ^ y ;
		int count = 0 ;
		
		while(xor > 0) {
			
			if((xor & 1) == 1)
				count++ ;
			
			xor >>= 1 ;
				
		}
		
		System.out.println(count);
		
	}
}
