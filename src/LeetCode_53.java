/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author Levi
 * @date 2020.5.29
 */
public class LeetCode_53 {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            cur = cur + nums[i];
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}
