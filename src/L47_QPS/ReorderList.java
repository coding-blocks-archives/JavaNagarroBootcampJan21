package L47_QPS;

import L47_QPS.MergeSort.ListNode;

public class ReorderList {

	public static void main(String[] args) {

	}

	public ListNode mid(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

	public ListNode reverseI(ListNode head) {

		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {

			ListNode ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;

		}

		return prev;

	}

	public void reorderList(ListNode h1) {

		ListNode midN = mid(h1);
		ListNode h2 = midN.next;
		midN.next = null;

		h2 = reverseI(h2);

		ListNode t1 = h1;
		ListNode t2 = h2;

		while (t1 != null && t2 != null) {

			ListNode a1 = t1.next;
			ListNode a2 = t2.next;

			t1.next = t2;
			t2.next = a1;

			t1 = a1;
			t2 = a2;
		}
	}

}
