package code;

import java.util.LinkedList;

/**
 * o(1)时间找到栈里最大的数
 */
public class FindLargeestInStack {

    private static LinkedList<Integer> stack = new LinkedList<>();
    private static LinkedList<Integer> largestStack = new LinkedList<>();

    public static void push(Integer i) {
        stack.push(i);
        if (largestStack.size() == 0 || i.intValue() >= largestStack.peekFirst().intValue()) {
            largestStack.push(i);
        }
    }

    public static Integer pop() {
        Integer top = stack.pop();
        if (top.intValue() == largestStack.peek().intValue())
            largestStack.pop();
        return top;
    }

    public static Integer getLargest() {

        return largestStack.peek();
    }
}
