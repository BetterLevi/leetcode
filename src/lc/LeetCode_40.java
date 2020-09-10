package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为定值的组合总数II
 * @author Levi
 * @date 2020.9.10
 */
public class LeetCode_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, res, tmp, 0, target);
        return res;
    }

    private void backTrack(int[] nums, List<List<Integer>> res, List<Integer> tmp, int start, int remain) {
        if(remain == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if(remain < 0) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[start] == nums[start - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            backTrack(nums, res, tmp, i + 1, remain - nums[i]);
            tmp.remove(tmp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] can = new int[]{10,1,2,7,6,1,5};
        LeetCode_40 l = new LeetCode_40();;
        l.combinationSum2(can, 8);
    }
}
