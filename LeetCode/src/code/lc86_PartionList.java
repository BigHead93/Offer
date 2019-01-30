package code;

/**
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class lc86_PartionList {

    public ListNode partition(ListNode head, int x) {
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode less = headNode, eng = headNode, mid;
        while (eng.next != null) {
            if (eng.next.val >= x) {
                eng = eng.next;
            } else {
                if (eng.next == less.next) {
                    less = less.next;
                    eng = eng.next;
                } else {
                    mid = eng.next;
                    eng.next = mid.next;
                    mid.next = less.next;
                    less.next = mid;
                    less = less.next;
                }
            }
        }
        return headNode.next;
    }
}
