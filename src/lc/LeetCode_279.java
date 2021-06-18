package lc;

/**
 * 完全平方数
 *
 * @author wei.liang
 * @since 2021/6/11
 */
public class LeetCode_279 {

    public int numSquares(int n) {
        int[] minCount = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                count = Math.min(count, minCount[i - j * j] + 1);
            }
            minCount[i] = count;
        }
        return minCount[n];
    }
}
