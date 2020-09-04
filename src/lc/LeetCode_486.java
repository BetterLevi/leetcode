package lc;

/**
 * 博弈问题 预测赢家
 * @author Levi
 * @date 2020.9.1
 */
public class LeetCode_486 {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        //dp[i][j]表示i-j的子数组玩家1可获取的最大分数
        int[][] dp = new int[len][len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            dp[i][i] = nums[i];
        }
        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }
        for (int l = 2; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l - 1;
                //玩家1选择后，玩家2选择使玩家1下次拿到较少分数的选择
                int playerChooseLeft = nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                int playerChooseRight = nums[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
                dp[i][j] = Math.max(playerChooseLeft, playerChooseRight);
            }
        }
        return 2 * dp[0][len - 1] > sum;

    }
}
