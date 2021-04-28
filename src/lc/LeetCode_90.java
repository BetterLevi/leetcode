package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wei.liang
 * @since 2021/3/31
 */
public class LeetCode_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new LinkedList<>();
        backTrack(nums, 0, res, tmp);
        return res;

    }

    private void backTrack(int[] nums, int index, List<List<Integer>> res, List<Integer> tmp) {
        if (index <= nums.length) {
            res.add(tmp);
        }
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTrack(nums, index + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
            while (++i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_90 lc = new LeetCode_90();
        int[] nums = {1,2,2};
        lc.subsetsWithDup(nums);
    }
}
