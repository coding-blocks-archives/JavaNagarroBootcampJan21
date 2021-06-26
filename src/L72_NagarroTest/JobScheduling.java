package L72_NagarroTest;

import java.util.LinkedList;
import java.util.Queue;

public class JobScheduling {

	private static class PP {
		int pno;
		int arrival;
		int burst;
		int end;
		int timeRemaining;

		public PP(int pno, int arrival, int burst) {
			this.pno = pno;
			this.arrival = arrival;
			this.burst = burst;
			this.timeRemaining = burst;
		}

		@Override
		public String toString() {
			return "P" + pno + ": BT " + burst + " AT " + arrival + " ET " + end;
		}
	}

	public static void main(String[] args) {

		int process = 4;
		int timeSlice = 2;

		int[] arrival = { 0, 1, 2, 3 };
		int[] burst = { 9, 5, 3, 4 };

		PP[] arr = new PP[process];

		for (int i = 0; i < arr.length; i++) {
			PP np = new PP(i, arrival[i], burst[i]);
			arr[i] = np;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			q.add(i);
		}

		int timeElapsed = 0;

		while (!q.isEmpty()) {

			int rp = q.remove();
			
			System.out.println("P" + (rp+1));

			PP pair = arr[rp];

			if (pair.timeRemaining <= timeSlice) {
				timeElapsed += pair.timeRemaining;
				pair.timeRemaining = 0;
				pair.end = timeElapsed;
			}

			else {
				timeElapsed += timeSlice;
				pair.timeRemaining -= timeSlice;
				q.add(rp);
			}

		}

		// TurnAroundTime
		int[] tat = new int[process];
		double tatsum = 0;	
		for (int i = 0; i < arr.length; i++) {
			tat[i] = arr[i].end - arr[i].arrival;
			System.out.print(tat[i] + " ");
			tatsum += tat[i];
		}
		System.out.println();

		// WaitingTime
		int[] wt = new int[process];
		double wtsum = 0;
		for (int i = 0; i < arr.length; i++) {
			wt[i] = tat[i] - arr[i].burst;
			System.out.print(wt[i] + " ");
			wtsum += wt[i];
		}
		System.out.println();

		System.out.println(String.format("%.6f", tatsum / process));
		System.out.println(String.format("%.6f", wtsum / process));

	}

}





