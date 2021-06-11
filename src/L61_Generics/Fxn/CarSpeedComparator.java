package L61_Generics.Fxn;

import java.util.Comparator;

public class CarSpeedComparator implements Comparator<Car>{

	@Override
	public int compare(Car t, Car o) {
		return t.speed - o.speed ;
	}

}
