package L23_Leetcode;

import java.util.ArrayList;

public class ALDemo {

	public static void main(String[] args) {

//		ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;
//		
//		ArrayList<Integer> temp1 = new ArrayList<>() ;
//		temp1.add(10) ;
//		temp1.add(20) ;
//		temp1.add(30) ;
//		
//		list.add(temp1) ;
// 		
//		ArrayList<Integer> temp2 = new ArrayList<>() ;
//		temp2.add(40) ;
//		temp2.add(50) ;
//		
//		list.add(temp2) ;
//		
//		System.out.println(list);
//		
//		list.get(0).add(100) ;
//		list.get(1).add(200) ;
//		
//		System.out.println(list);

//		ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;
//		
//		ArrayList<Integer> temp = new ArrayList<>() ;
//		temp.add(10) ;
//		temp.add(20) ;
//		temp.add(30) ;	
//		list.add(temp) ;
//		
//		temp = new ArrayList<Integer>() ;
//		temp.add(40) ;
//		temp.add(50) ;		
//		list.add(temp) ;
//		
//		temp = new ArrayList<Integer>();
//		temp.add(60) ;
//		temp.add(70) ;
//		list.add(temp) ;
//		
//		System.out.println(list);
//		
//		temp.add(80) ;
//		
//		System.out.println(list);
//		
//		temp.remove(temp.size()-1) ;
//		temp.remove(temp.size()-1) ;
//		
//		System.out.println(list);
//		

//		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//
//		ArrayList<Integer> t1 = new ArrayList<Integer>();
//		t1.add(10);
//		t1.add(20);
//		t1.add(30);
//		t1.add(40);

//		ArrayList<Integer> t2 = t1 ;
//		
//		list.add(t1) ;
//		list.add(t2) ;
//		
//		System.out.println(list);

//		ArrayList<Integer> t2 = new ArrayList<>(t1);

//		for(int i = 0 ; i < t1.size() ; i++)
//		{
//			t2.add(t1.get(i)) ;
//		}

//		list.add(t1);
//		list.add(t2);
//		t2.add(100);
//
//		System.out.println(list);

		ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;
		
		ArrayList<Integer> temp = new ArrayList<>() ;
		
		temp.add(10) ;
		temp.add(20) ;
		
		list.add(new ArrayList<>(temp)) ;
		
		temp.add(30) ;
		temp.add(40) ;
		
		list.add(new ArrayList<>(temp)) ;
		
		temp.add(50) ;
		
		list.add(new ArrayList<>(temp)) ;
		
		
		System.out.println(list);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
