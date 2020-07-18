/**
 * 买卖股票的最佳时机
 * @author Levi
 * @date 2020.7.18
 */
public class LeetCode_121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1;j < prices.length; j++) {
                int tmp = prices[j] - prices[i];
                if (tmp <= 0) {
                    continue;
                }
                res = Math.max(res, tmp);
            }
        }
        return res;
    }

    public int kadane_alo(int[] prices) {
                int maxCur = 0;
                int maxSofar = prices[0];
                for (int i = 1; i < prices.length; i++) {
                    maxCur = Math.max(maxCur, maxCur + prices[i] - prices[i -1]);
                    maxSofar = Math.max(maxCur, maxSofar);
                }
                return maxSofar;
    }
}
