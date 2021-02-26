package L12_ArrayList;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		// print
		System.out.println(list);

		// no. of elements
		System.out.println(list.size());

		// add
		// tc : O(1) constant
		list.add(10);
		list.add(20);
		list.add(30);

		System.out.println(list);
		System.out.println(list.size());

		// add at a particular index
		// range : 0 -> size
		// tc : worst case -> 0 index add , best case -> size index add
		list.add(1, 50);
		System.out.println(list);
		list.add(3, 100);
		System.out.println(list);
		list.add(list.size(), 200);
		System.out.println(list);

		// get
		// range : 0 -> size-1
		// tc : constant O(1)
		System.out.println(list.get(2));
		System.out.println(list.get(0));
		System.out.println(list.get(list.size() - 1));

		// set
		// range : 0 -> size-1
		// tc : constant O(1)
		list.set(2, 300);
		System.out.println(list);
		list.set(list.size() - 1, 400);
		System.out.println(list);

		// remove
		// range : 0 -> size-1
		// tc : worst case -> 0 index remove , best case -> size-1 index remove
		list.remove(1);
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
		list.remove(list.size() - 1);
		System.out.println(list);

		// print
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		for(int val : list)
			System.out.println(val);

	}

}









