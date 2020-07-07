import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度
 *
 * @author Levi
 * @date 2020.7.4
 */
public class LeetCode_32 {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] sc = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '(') {
                st.push(i);
            } else {
                if (!st.isEmpty()) {
                    if (sc[st.peek()] == '(') st.pop();
                    else st.push(i);
                } else {
                    st.push(i);
                }
            }
        }
        int res = 0;
        if (st.isEmpty()) return sc.length;
        int a = sc.length, b = 0;
        while (!st.isEmpty()) {
            b = st.pop();
            res = Math.max(res, a - b - 1);
            a = b;
        }
        return Math.max(res, a);
    }

    public int longestValidParentheses_dp(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();    //Store indices of '('
        int[] result = new int[s.length()];//Store the length of the current longest valid sequence.
        Arrays.fill(result, 0);

        int max = 0;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.isEmpty())
                    continue;
                else if (stack.peek() > 0)
                    //May connect two valid sequences, or increase the length of current valid sequence.
                    result[i] = 2 + result[stack.pop() - 1] + result[i - 1];
                else {
                    //Handle the special case that the leftmost char is a '('
                    result[i] = 2 + result[i - 1];
                    stack.pop();
                }

                max = Math.max(result[i], max);
            }
        return max;
    }
}
