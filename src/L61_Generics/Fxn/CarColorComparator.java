package L61_Generics.Fxn;

import java.util.Comparator;

public class CarColorComparator implements Comparator<Car>{

	@Override
	public int compare(Car t, Car o) {
		return t.color.compareTo(o.color) ;
	}

}
