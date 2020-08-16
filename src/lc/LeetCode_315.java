package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Levi
 * @date 2020.7.11
 */
public class LeetCode_315 {
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(0);
            return res;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res.add(count);
        }
        res.add(0);
        return res;

    }
}
