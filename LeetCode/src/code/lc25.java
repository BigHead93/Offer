package code;

public class lc25 {

	public static void main(String[] args) {
		int count = 3;
		while(count-- > 0)
			System.out.print(count);

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		ListNode tmp;
		int count = 0;
		while(curr != null && count < k) {
			curr = curr.next;
			count++;
		}
		if(count == k) {
			curr = reverseKGroup(curr, k);
			while(count-- > 0) {
				tmp = head.next;
				head.next = curr;
				curr = head;
				head = tmp;
			}
			head = curr;
		}
		return curr;
	}

}
