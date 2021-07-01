package lc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wei.liang
 * @since 2021/6/28
 */
public class LeetCode_494 {
    private char[] calc = new char[]{'+', '-'};
    private int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        LinkedList<Character> ele = new LinkedList<>();
        backTracking(nums, ele, target, 0);
        return res;
    }

    private void backTracking(int[] nums, LinkedList<Character> ele, int target, int index) {
        if (ele.size() == nums.length * 2) {
            LinkedList<Character> temp = new LinkedList<>();
            temp.addAll(ele);
            if (target == calcRes(temp)) {
                res++;
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            for (char c : calc) {
                ele.offer(c);
                ele.offer((char) nums[i]);
                backTracking(nums, ele, target, i + 1);
                //remove element
                ele.removeLast();
                //remove calc
                ele.removeLast();
            }
        }
    }

    private int calcRes(Queue<Character> ele) {
        int res = 0;
        while (!ele.isEmpty()) {
            char cur = ele.poll();
            char next = ele.poll();
            if ('+' == cur) {
                res += Integer.valueOf(next);
            } else {
                res -= Integer.valueOf(next);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        LeetCode_494 lc = new LeetCode_494();
        System.out.println(lc.findTargetSumWays(nums, 3));
    }
}
