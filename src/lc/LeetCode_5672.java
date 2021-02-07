package lc;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 检查数组是否经排序和轮转得到
 * @author wei.liang
 * @since 2021/2/7
 */
public class LeetCode_5672 {
    public boolean check(int[] nums) {
        int[] sort = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sort);
        List<Integer> ks = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sort[0]) {
                ks.add(i);
            }
        }
        for (int s : ks) {
            boolean res = true;
            for (int i = 0; i < nums.length; i++) {
                if (sort[i] == nums[(i + s) % sort.length]) {
                    continue;
                }
                res = false;
            }
            if (res) {
                return true;
            }
        }
        return false;
    }

    public int maximumScore(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return nums[0] + nums[1];
        }
        return maximumScore(nums[0] - 1, nums[1] - 1, nums[2]) + 1;
    }


        public static void main(String[] args) {
        LeetCode_5672 lc = new LeetCode_5672();
        int[] nums = {6, 10, 6};
//        lc.check(nums);
        lc.maximumScore(4, 4, 6);
    }
}
