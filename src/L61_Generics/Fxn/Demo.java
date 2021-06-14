package L61_Generics.Fxn;

import java.util.Comparator;

public class Demo {

	public static void main(String[] args) {

		Integer[] arr = { 100, 200, 30, 40, 50 };
		display(arr);

		String[] sarr = { "hello", "hi", "bye", "code" };
		display(sarr);

		Car[] cars = new Car[5]; // array has been created which will store cars
		cars[0] = new Car(100, 5000, "Red");
		cars[1] = new Car(50, 7000, "Black");
		cars[2] = new Car(200, 2000, "White");
		cars[3] = new Car(30, 1000, "Blue");
		cars[4] = new Car(150, 3000, "Gray");

		display(cars);

		// bubbleSort(cars);
		// display(cars) ;

		// bubbleSort(cars, new CarSpeedComparator());

		bubbleSort(arr, new IntegerComparator());
		display(arr);
		
	}

	// no comparison required
	public static <T> void display(T[] arr) {

		System.out.println("-----------------------");
		for (T val : arr) {
			System.out.println(val);
		}
		System.out.println("-----------------------");
	}

	// comparison required
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> c) {

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (c.compare(arr[j], arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
