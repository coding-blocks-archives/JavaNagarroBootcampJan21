package L61_Generics.Class;

import java.util.ArrayList;

import L61_Generics.Fxn.Car;

public class Client {

	public static void main(String[] args) throws Exception {
		
		// Pair<String, Float> p = new Pair<>() ;
		
		LinkedListGeneric<Car> ll = new LinkedListGeneric<Car>() ;
		ll.addLast(new Car(100, 5000, "Red"));
		ll.addLast(new Car(50, 7000, "Black"));
		ll.addLast(new Car(200, 2000, "White"));
		ll.addLast(new Car(30, 1000, "Blue"));
		ll.addFirst(new Car(150, 3000, "Gray"));
		ll.display();
		
		
	}
}
