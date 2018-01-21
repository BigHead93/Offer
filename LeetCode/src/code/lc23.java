package code;

public class lc23 {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;
		return helper(lists, 0, lists.length-1);
    }
	private ListNode helper(ListNode[] lists, int l, int r) {
		if(l < r) {
			int m = ( l + r ) / 2;
			return merge(helper(lists, l, m), helper(lists, m+1, r));
		}
		return lists[l];
	}
	private ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		}else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
}
