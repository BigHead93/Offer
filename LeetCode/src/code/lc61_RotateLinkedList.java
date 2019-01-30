package code;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 */
public class lc61_RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        int length = 1, step;
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length;
        if(k == 0)
            return head;
        else{
            tail.next = head;
            step = length - k;
            while(step > 1) {
                head = head.next;
                step--;
            }
            tail = head;
            head = head.next;
            tail.next = null;
            return head;
        }
    }
}
