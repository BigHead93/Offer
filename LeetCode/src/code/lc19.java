package code;

import java.util.Objects;

public class lc19 {
	/**
	 * Given a linked list, remove the n-th node from the end of list and return its head.
	 * Example:
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * After removing the second node from the end, the linked list becomes 1->2->3->5.
	 * Note:
	 * Given n will always be valid.
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tail = head;
		ListNode predel = new ListNode(0);
		predel.next = head;
		for(int i = 0; i < n - 1; i++) {
			tail = tail.next;
		}
		while(tail.next != null ) {
			tail = tail.next;
			predel = predel.next;
		}
		if(predel.next == head)
			return head.next;
		predel.next = predel.next.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		
		lc19 test = new lc19();
		ListNode b = test.removeNthFromEnd(a, 6);
		System.out.println(b);
//		System.out.println(b.val);
//		System.out.println(b.next.val);
//		System.out.println(b.next.next.val);
//		System.out.println(b.next.next.next.val);
		String aa = "hello";
		String bb = null;
		System.out.println(aa.indexOf(Objects.requireNonNull(bb)));
	}
	
}


