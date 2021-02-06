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
        for(int p : cardPoints) {
            sum += p;
        }
        if(k >= cardPoints.length) {
            return sum;
        }
        int window = 0;
        for(int i = 0; i < cardPoints.length - k; i++) {
            window += cardPoints[i];
        }
        int res = sum - window;
        for(int i = cardPoints.length - k; i < cardPoints.length; i++) {
            window = window - cardPoints[i - cardPoints.length + k] + cardPoints[i];
            res = Math.max(res, sum - window);
        }
        return res;
    }
}
