package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * @author Levi
 * @date 2020.8.16
 */
public class LeetCode_46 {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<>();
        }
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(nums, path);
        return res;
    }

    public void backTrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backTrack(nums, path);
            path.removeLast();
        }
    }
}
