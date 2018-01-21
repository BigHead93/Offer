package code;

public class lc21 {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		
		ListNode l3, tail;

		if (l1.val <= l2.val) {
			tail = l1;
			l1 = l1.next;
		} else {
			tail = l2;
			l2 = l2.next;
		}
		l3 = tail;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				tail.next = l1;
				tail = tail.next;
				l1 = l1.next;
			} else {
				tail.next = l2;
				tail = tail.next;
				l2 = l2.next;
			}
		}
		if (l1 != null)
			tail.next = l1;
		if (l2 != null)
			tail.next = l2;
		return l3;

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = mergeTwoLists(l1, l2);
		
		while(l3 != null) {
			System.out.print(l3.val);
			l3 = l3.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
