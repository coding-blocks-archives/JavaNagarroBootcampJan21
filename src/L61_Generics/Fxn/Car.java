package L61_Generics.Fxn;

public class Car implements Comparable<Car> {

	int speed;
	int price;
	String color;

	public Car(int speed, int price, String color) {

		this.speed = speed;
		this.price = price;
		this.color = color;
	}

	@Override
	public String toString() {
		return "S:" + speed + "\tP:" + price + "\tC:" + color;
	}

	@Override
	public int compareTo(Car other) {

		// speed
		return this.speed - other.speed;
		
		// price
		// return other.price - this.price ;
		
		// color
		// return this.color.compareTo(other.color) ;
	}

}




