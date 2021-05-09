package L42_BitManipulation;

public class Demo {

	public static void main(String[] args) {

		System.out.println(20 | 40);
		System.out.println(36 & 40);
		System.out.println(36 ^ 40);


		byte by = (byte) (-78 >>> 1);

		System.out.println(by);
	}

}
