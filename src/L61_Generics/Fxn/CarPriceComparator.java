package L61_Generics.Fxn;

import java.util.Comparator;

public class CarPriceComparator implements Comparator<Car>{

	@Override
	public int compare(Car t, Car o) {
		return o.price - t.price ;
	}

}
