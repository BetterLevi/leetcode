package jianzhi;

import sun.nio.cs.ext.MacArabic;

/**
 * 股票的最大利润
 *
 * @author Levi
 * @date 2020.8.10
 */
public class JianZhi_63 {
    public int maxProfit(int[] prices) {
        int cost = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - cost);
            cost = Math.min(cost, prices[i]);
        }
        return profit;
    }
}
