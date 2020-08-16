package lc;

/**
 * 打家劫舍II
 * @author Levi
 * @date 2020.8.5
 */
public class LeetCode_213 {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int tmp0 = 0;
        int tmp1 = nums[0];
        int tmp2;
        int max = nums[0];
        for(int i = 2; i <= nums.length - 1; i++) {
            tmp2 = Math.max(nums[i - 1] + tmp0, tmp1);
            tmp0 = tmp1;
            tmp1 = tmp2;
            max = Math.max(max, tmp2);
        }
        tmp0 = 0;
        tmp1 = 0;
        for(int i = 2; i <= nums.length; i++) {
            tmp2 = Math.max(tmp1, tmp0 + nums[i - 1]);
            tmp0 = tmp1;
            tmp1 = tmp2;
            max = Math.max(max, tmp2);
        }
        return max;
    }
}
