package code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid. The brackets must close in the
 * correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * @author I317032
 */
public class lc20 {
    public boolean isValid1(String s) {
        if (s == null || s.length() % 2 != 0)
            return false;
        if (s.length() == 0)
            return true;
        boolean flag = true;
        char[] cs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<Character>();
        for (char c : cs) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty())
                        return false;
                    flag = stack.pop() == '(' ? true : false;
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;
                    flag = stack.pop() == '{' ? true : false;
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;
                    flag = stack.pop() == '[' ? true : false;
                    break;
            }
            if (flag == false)
                return flag;
        }
        if (stack.isEmpty() != true)
            flag = false;
        return flag;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c)
                        return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid3(String s) {
        Stack<Character> cs = new Stack<>();
        for (Character c : cs) {
            if (c == '{' || c == '[')
                cs.push(c);
            if (c == '}' || c == ']') {
                if (cs.isEmpty())
                    return false;
                Character top = cs.pop();
                if (top != (c == '}' ? '}' : ']'))
                    return false;
            }
        }
        return cs.isEmpty();
    }


    public static void main(String[] args) {
        String s = "({[]]})";
        lc20 test = new lc20();
        System.out.println(test.isValid2(s));
    }
}
