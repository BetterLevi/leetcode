package jianzhi;

import java.util.Stack;

/**
 * 栈的压入 弹出序列
 * @author Levi
 * @date 2020.9.10
 */
public class JianZhi_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> tmp = new Stack<>();
        int p = 0;
        for (int i = 0; i < pushed.length;) {
            if (!tmp.isEmpty() && tmp.peek() == popped[p]) {
                tmp.pop();
                p++;
            } else if (pushed[i] == popped[p]) {
                p++;
                i++;
            } else {
                tmp.push(pushed[i]);
                i++;
            }
        }
        while (!tmp.isEmpty() && p < popped.length) {
            if (tmp.pop() != popped[p]) {
                return false;
            }
            p++;
        }
        return true;
    }

    public boolean validateStackSequences_bet(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

}
