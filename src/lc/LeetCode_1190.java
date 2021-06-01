package lc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * 反转每对括号间的子串, e.g.
 * <p>
 *     输入：s = "(ed(et(oc))el)"
 *     输出："leetcode"
 * </p>
 * @author wei.liang
 * @since 2021/5/26
 */
public class LeetCode_1190 {
    public String reverseParentheses(String s) {
//        Stack<Character> cs = new Stack<>();
        Deque<Character> cs = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                cs.addLast(c);
                continue;
            }
            List<Character> reverse = new ArrayList<>();
            while (cs.size() != 0) {
                char top = cs.getLast();
                if (top != '(') {
                    reverse.add(top);
                    cs.removeLast();
                } else {
                    cs.removeLast();
                    break;
                }
            }
            reverse.forEach(cs::addLast);
        }
        StringBuilder res = new StringBuilder();
        for (char c : cs) {
            res.append(c);
        }
        return res.toString();
    }
}
