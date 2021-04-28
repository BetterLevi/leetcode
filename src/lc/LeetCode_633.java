package lc;

/**
 * @author wei.liang
 * @since 2021/4/28
 */
public class LeetCode_633 {
    public boolean judgeSquareSum(int c) {
        if(c <= 2) {
            return true;
        }
        int[] dp = new int[c/2 + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 0; i < c / 2; i++) {
            dp[i] = i * i;
            if(c - dp[i] < 0) {
                return false;
            }
            int b = (int)Math.sqrt(c - dp[i]);
            if(b * b == (c - dp[i])) {
                return true;
            }
        }
        return false;

    }

    public boolean judgeSquareSum_ans(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode_633 lc = new LeetCode_633();
        lc.judgeSquareSum(11);
    }
}
