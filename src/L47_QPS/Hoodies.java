package L47_QPS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hoodies {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		ArrayList<Integer> order = new ArrayList<>();

		Queue<Integer>[] q = new Queue[5];

		for (int i = 0; i < q.length; i++) {
			q[i] = new LinkedList<>();
		}

		int ops = scn.nextInt();

		while (ops > 0) {

			char ch = scn.next().charAt(0);

			if (ch == 'E') {

				int cno = scn.nextInt();
				int rno = scn.nextInt();

				q[cno].add(rno);

				if (!order.contains(cno))
					order.add(cno);

			} else {

				int courseRemove = order.get(0);
				int rollRemove = q[courseRemove].remove();
				
				System.out.println(courseRemove + " " + rollRemove);
				
				if(q[courseRemove].isEmpty()) {
					order.remove(0) ;
				}
			}

			ops--;
		}

	}

}
