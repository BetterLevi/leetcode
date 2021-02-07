package lc;

/**
 * 可获得的最大点数
 *
 * @author wei.liang
 * @since 2021/2/6
 */
public class LeetCode_1423 {

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int len = cardPoints.length;
        for(int p : cardPoints) {
            sum += p;
        }
        if(k >= len) {
            return sum;
        }
        int window = 0;
        for(int i = 0; i < len - k; i++) {
            window += cardPoints[i];
        }
        int res = sum - window;
        for(int i = len - k; i < len; i++) {
            window = window - cardPoints[i - len + k] + cardPoints[i];
            res = Math.max(res, sum - window);
        }
        return res;
    }
}
