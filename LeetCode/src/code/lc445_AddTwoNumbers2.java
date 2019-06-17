package code;

import java.util.LinkedList;

public class lc445_AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        int remain = 0;
        ListNode head = null;
        while (stack1.size() > 0 || stack2.size() > 0 || remain > 0) {
            int addend1 = stack1.size() > 0 ? stack1.pop().val : 0;
            int addend2 = stack2.size() > 0 ? stack2.pop().val : 0;
            int sum = addend1 + addend2 + remain;
            remain = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = head;
            head = tmp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        lc445_AddTwoNumbers2 test = new lc445_AddTwoNumbers2();
        ListNode ans = test.addTwoNumbers(l1, l2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
}
