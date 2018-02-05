package code;
public class lc19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null ) return null;
		ListNode tail, nth;
		int flag = 1;
		tail = nth = head;
		while(tail.next != null && flag < n) {
			tail = tail.next;
			flag++;
		}
		if(tail.next == null && flag < n) return null;
		else if(tail.next == null && flag == n) { head = head.next; return head;}
		tail = tail.next;
		while(tail.next != null) {
			tail = tail.next;
			nth = nth.next;
		}
		nth.next = nth.next.next;
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
		
	}
	
}


