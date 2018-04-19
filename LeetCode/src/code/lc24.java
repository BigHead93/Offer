package code;

public class lc24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		ListNode first, second, third, forth;
		if (head == null || head.next == null)
			return head;
		
		first = head;
		second = first.next;

		head = second;

		do {
			third = second.next;
			forth = third == null ? null : third.next;
			
			first.next = forth == null ? third : forth;
			second.next = first;

			first = third;
			second = forth;
		} while (second != null);
		
		return head;
	}

}
