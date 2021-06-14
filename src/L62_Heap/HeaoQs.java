package L62_Heap;

import java.util.ArrayList;

public class HeaoQs {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());

		lists.get(0).add(10);
		lists.get(0).add(20);
		lists.get(0).add(40);

		lists.get(1).add(5);
		lists.get(1).add(12);
		lists.get(1).add(15);
		lists.get(1).add(20);

		lists.get(2).add(17);
		lists.get(2).add(80);

		lists.get(3).add(1);
		lists.get(3).add(3);
		lists.get(3).add(8);
		lists.get(3).add(11);

		System.out.println(mergeKSortedLists(lists));

		int[] arr = { 20, 5, 10, 7, 8, 15, 3, 30, 1 };
		kLargestElements1(arr, 3);
	}

	private static class Pair implements Comparable<Pair> {
		int data;
		int lno;
		int idxno;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> ans = new ArrayList<>();

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.lno = i;
			np.idxno = 0;
			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();

			ans.add(rp.data);

			// pair edit -> heap add
			rp.idxno++;

			if (rp.idxno < lists.get(rp.lno).size()) {
				rp.data = lists.get(rp.lno).get(rp.idxno);
				heap.add(rp);
			}
		}

		return ans;

	}

	public static void kLargestElements(int[] arr, int k) {

		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {

			int weaker = heap.get();

			if (arr[i] > weaker) {
				heap.remove();
				heap.add(arr[i]);
			}

		}

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}

	}

	private static class KLPair implements Comparable<KLPair> {
		int data;

		@Override
		public int compareTo(KLPair o) {
			return o.data - this.data;
		}

		@Override
		public String toString() {
			return data + "";
		}
	}

	public static void kLargestElements1(int[] arr, int k) {

		HeapGeneric<KLPair> heap = new HeapGeneric<>();

		for (int i = 0; i < k; i++) {
			KLPair np = new KLPair();
			np.data = arr[i];
			heap.add(np);
		}

		for (int i = k; i < arr.length; i++) {

			int weaker = heap.get().data;

			if (arr[i] > weaker) {
				heap.remove();

				KLPair np = new KLPair();
				np.data = arr[i];
				heap.add(np);
			}

		}

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}

	}

}
