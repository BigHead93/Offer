package code;

import java.util.Stack;

public class lc32_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int left = -1;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '(')
                stack.push(i);
            else {
                if(stack.empty()) {
                    left = i;
                } else {
                    stack.pop();
                    max = Math.max(max, i - (stack.empty() ? left : stack.peek()));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lc32_LongestValidParentheses test = new lc32_LongestValidParentheses();
        System.out.println(test.longestValidParentheses("(()()))(()"));
    }
}
