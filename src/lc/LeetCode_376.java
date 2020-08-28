package lc;

/**
 * 摆动序列
 * @author Levi
 * @date 2020.8.28
 */
public class LeetCode_376 {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        dp[1] = nums[1] != nums[0] ? 2 : 1;
        int pre = nums[1] - nums[0];
        for(int i = 2; i < nums.length; i++) {
            int cur = nums[i] - nums[i - 1];
            if((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)) {
                dp[i] = dp[i - 1] + 1;
                pre = cur;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[nums.length - 1];
    }


    public int wiggleMaxLength_bet(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        return count;
    }
}
