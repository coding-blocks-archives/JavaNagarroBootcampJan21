package L13_TimeComplexity;

public class TimeSpaceDemo {

	public static void main(String[] args) {

		int n = 100000;

		for (int i = 1; i <= n; i++)
			System.out.println("hello");

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				System.out.println("hello");

	}

}
