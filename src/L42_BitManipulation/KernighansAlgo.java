package L42_BitManipulation;

public class KernighansAlgo {

	public static void main(String[] args) {
	
		int x = 25 ;
		System.out.println(Integer.toBinaryString(x));
		
		int count = 0 ;
		
		while(x != 0) {
			
			int rmsbMask = (x & (-x)) ;			
			x = x - rmsbMask ;
			count++ ;
			
		}
		
		System.out.println(count);

	}

}
