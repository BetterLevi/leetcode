package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为定值的组合
 * @author Levi
 * @date 2020.9.9
 */
public class LeetCode_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backTrack(candidates, res, tmp, target, 0);
        return res;
    }

    private void backTrack(int[] nums, List<List<Integer>> res, List<Integer> tmp, int remain, int start) {
        if(remain == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if(remain < 0) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTrack(nums, res, tmp, remain - nums[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
