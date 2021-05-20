package L47_QPS;

import L47_QPS.MergeSort.ListNode;

public class LLPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public boolean isPalindrome(ListNode head) {

		ListNode[] left = new ListNode[1] ;
		left[0] = head ;
		return isPalindromeR(head, left);

	}

	public boolean isPalindromeR(ListNode right, ListNode[] left) {

		if (right == null)
			return true;

		boolean res = isPalindromeR(right.next, left);

		if (left[0].val == right.val && res) {
			left[0] = left[0].next;
			return true;
		} else {
			left[0] = left[0].next;
			return false;
		}

	}

}
