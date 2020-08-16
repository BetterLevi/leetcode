package lc;

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

    public static int trailingZeroes(int n) {
        long m = 1;
        for(int i = n; i > 0; i--) {
            m *= i;
        }
        if(m % 10 != 0) {
            return 0;
        }
        int len2 = 0;
        while(m % 10 == 0) {
            len2++;
            m = m /10;
        }
        return len2;
    }
    public static void main(String[] args) {
        trailingZeroes(13);
    }
}
