package L42_BitManipulation ;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		
		System.out.println(grayCode(3));
		
	}
	
	public static List<Integer> grayCode(int n) {

		if(n == 1) {
			List<Integer> br = new ArrayList<>();
			br.add(0) ;
			br.add(1) ;
			return br ;			
		}
		
		List<Integer> rr = grayCode(n - 1);

		List<Integer> mr = new ArrayList<>();

		for (int val : rr) {
			mr.add(val);
		}

		int mult = (int) Math.pow(2, n - 1);

		for (int i = rr.size() - 1; i >= 0; i--) {
			int val = rr.get(i);

			mr.add(mult * val);
		}

		return mr;

	}

}
