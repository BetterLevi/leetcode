package lc;

import com.sun.tools.corba.se.idl.constExpr.LessEqual;

import java.util.Stack;

/**
 * 表达式求值
 *
 * @author wei.liang
 * @since 2021/3/10
 */
public class LeetCode_224 {

    public int calculate_own(String s) {
        //wrong case is "- (3 + (4 + 5))"
        s = s.replace("(", "");
        s = s.replace(")", "");
        int res = 0;
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res += num * sign;
                num = 0;
                sign = c == '+' ? 1 : -1;
            }
        }
        res += num * sign;
        return res;
    }

    public int calculate_ans(String s) {
        if(s == null) return 0;
        int result = 0;
        int sign = 1;
        int num = 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(sign);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');

            } else if(c == '+' || c == '-') {
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1: -1);
                num = 0;

            } else if(c == '(') {
                stack.push(sign);

            } else if(c == ')') {
                stack.pop();
            }
        }

        result += sign * num;
        return result;
    }

    public static void main(String[] args) {
        LeetCode_224 lc = new LeetCode_224();
        System.out.println(lc.calculate_own("1+(2+3)"));
    }
}
