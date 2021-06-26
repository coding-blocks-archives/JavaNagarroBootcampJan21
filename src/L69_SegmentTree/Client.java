package L69_SegmentTree;

public class Client {

	public static void main(String[] args) {

		int[] arr = { 5, 2, 10, 3, -6, -4, 12, 13 };
		SegmentTree st = new SegmentTree(arr, new QueryMax()) ;
		st.display();
		
		System.out.println(st.rangeQuery(2, 5));
		st.update(4, 2);
		st.display();
		System.out.println(st.rangeQuery(2, 5));

	}

}
