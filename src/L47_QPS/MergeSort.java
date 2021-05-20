package L47_QPS;

public class MergeSort {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode mergeTwoListsR(ListNode h1, ListNode h2) {

		if (h1 == null) {
			return h2;
		}

		if (h2 == null) {
			return h1;
		}

		if (h1.val <= h2.val) {
			h1.next = mergeTwoListsR(h1.next, h2);
			return h1;
		} else {
			h2.next = mergeTwoListsR(h1, h2.next);
			return h2;
		}

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

	public ListNode sortList(ListNode h1) {

		if(h1 == null || h1.next == null) {
			return h1 ;
		}
		
		ListNode midN = mid(h1);
		ListNode h2 = midN.next;
		midN.next = null;

		ListNode sfph = sortList(h1);
		ListNode ssph = sortList(h2);

		ListNode merged = mergeTwoListsR(sfph, ssph);

		return merged;

	}

	public static void main(String[] args) {

	}

}
