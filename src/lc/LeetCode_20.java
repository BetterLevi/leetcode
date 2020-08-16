package lc;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author Levi
 * @date 2020.8.14
 */
public class LeetCode_20 {
    public boolean isValid(String s) {
        char[] sc = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(sc[i]);
            } else if (stack.peek() == '{' && sc[i] == '}') {
                stack.pop();

            } else if (stack.peek() == '[' && sc[i] == ']') {
                stack.pop();

            } else if (stack.peek() == '(' && sc[i] == ')') {
                stack.pop();

            } else {
                stack.push(sc[i]);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid_bet(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
