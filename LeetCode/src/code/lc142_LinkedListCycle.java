package code;

import java.util.HashSet;
import java.util.Set;

public class lc142_LinkedListCycle {
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while(head != null) {
            boolean exist = nodeSet.contains(head);
            if(exist)
                return head;
            else{
                nodeSet.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                ListNode slow2 = head;
                while(slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
