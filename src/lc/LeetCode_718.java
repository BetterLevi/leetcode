package lc;

/**
 * 最长重复子数组
 *
 * @author Levi
 * @date 2020.7.1
 */
public class LeetCode_718 {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    res = Math.max(res, dp[i - 1][j - 1] + 1);
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return res;
    }
}
