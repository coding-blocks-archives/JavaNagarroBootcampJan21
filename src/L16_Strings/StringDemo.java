package L16_Strings;

public class StringDemo {

	public static void main(String[] args) {

		String str = "hello";

		System.out.println(str);
		System.out.println(str.length());

		// charAt
		System.out.println(str.charAt(1)); // e
		System.out.println(str.charAt(3)); // l
		System.out.println(str.charAt(str.length() - 1));

		// substring
		System.out.println(str.substring(1, 3)); // el
		System.out.println(str.substring(0, 4)); // hell
		String res = str.substring(0, str.length()); // hello
		System.out.println(res);
		// System.out.println(str.substring(0,6)); // error

		System.out.println(str.substring(1)); // ello
		System.out.println(str.substring(3)); // lo

		// concat
		String s = "hibye";

		String s1 = "hi";
		String s2 = "bye";
		String s3 = s1 + s2;
		System.out.println(s1 + ", " + s2 + ", " + s3);
		String s4 = s1.concat(s2);
		System.out.println(s1 + ", " + s2 + ", " + s4);

		// starts With
		System.out.println(str.startsWith("hel"));
		System.out.println(str.startsWith("Hel"));

		// ends With
		System.out.println(str.endsWith("lo"));
		System.out.println(str.endsWith("Lo"));

		// index Of
		System.out.println(str.indexOf("l"));
		System.out.println(str.lastIndexOf("l"));

		// equals and ==
		s1 = "Hello";
		s2 = s1;
		s3 = "Hello";
		s4 = new String("Hello");

		System.out.println((s1 == s2) + ", " + s1.equals(s2));
		System.out.println((s1 == s3) + ", " + s1.equals(s3));
		System.out.println((s1 == s4) + ", " + s1.equals(s4));

		str = str.replace('l', 'w');

		System.out.println(str);
		
		long start = System.currentTimeMillis() ;
		append() ;
		long end = System.currentTimeMillis() ;
		
		System.out.println(end-start);

	}

	public static void append() {

		int n = 100000;

		String str = "";

		for (int i = 1; i <= n; i++)
			str += i;

	}

}
