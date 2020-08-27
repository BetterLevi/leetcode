package lc;

import java.util.*;

/**
 * 递增子序列
 *
 * @author Levi
 * @date 2020.8.25
 */
public class LeetCode_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> sub = new ArrayList<>();
        helper(res, sub, 0, nums);
        return new ArrayList<>(res);
    }

    private void helper(Set<List<Integer>> res, List<Integer> sub, int index, int[] nums) {
        if (sub.size() > 1) {
            res.add(new ArrayList<>(sub));
        }
        for (int i = index; i < nums.length; i++) {
            if (sub.size() == 0 || sub.get(sub.size() - 1) <= nums[i]) {
                sub.add(nums[i]);
                helper(res, sub, i + 1, nums);
                sub.remove(sub.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_491 l = new LeetCode_491();
        int[] nums = {4, 6, 7, 7};
        l.findSubsequences(nums);
    }
}
