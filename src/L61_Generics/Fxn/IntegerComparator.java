package L61_Generics.Fxn;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer t, Integer o) {
		return t - o ;
	}

}
