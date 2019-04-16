package code;

import java.util.HashMap;
import java.util.Map;

public class LRUImpl<T> {

    private static final Object PRESENT = new Object();
    private int maxLen;
    private Map<T, Node> map = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUImpl(int maxLen) {
        this.maxLen = maxLen;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            builder.append(tmp.toString());
            tmp = tmp.next;
        }
        return builder.toString();
    }

    public void insert(T obj) {
        if (map.size() == 0) {
            Node node = new Node(obj);
            head = node;
            tail = node;
            map.put(obj, node);
        } else if (map.containsKey(obj)) {
            Node node = map.get(obj);
            if (head.equals(node))
                return;
            else {
                if (tail == node) {
                    tail = node.pre;
                    tail.next = null;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                node.next = head;
                node.pre = null;
                head.pre = node;
                head = node;
            }
        } else {
            if (map.size() == maxLen) {
                Node oldTail = tail;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    tail = oldTail.pre;
                    tail.next = null;
                }
                map.remove(oldTail.val);
            }
            Node newHead = new Node(obj);
            newHead.next = head;
            if (head == null) {
                head = newHead;
                tail = newHead;
            } else {
                head.pre = newHead;
                head = newHead;
            }
            map.put(obj, newHead);
        }
    }

    static class Node<T> {
        T val;
        Node pre;
        Node next;

        public Node(T val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return " " + val;
        }
    }

    public static void main(String[] args) {
        LRUImpl test = new LRUImpl(2);
        test.insert('a');
        System.out.println(test);
        test.insert('b');
        System.out.println(test);
        test.insert('c');
        System.out.println(test);
        test.insert('d');
        System.out.println(test);
        test.insert('c');
        System.out.println(test);
        test.insert('b');
        System.out.println(test);
    }

}
