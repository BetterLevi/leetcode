package lc;

/**
 * 比特位计数
 * @author wei.liang
 * @since 2021/3/3
 */
public class LeetCode_338 {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & i - 1) == 0) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - (tableSizeFor(i) >> 1)] + 1;
            }
        }
        return dp;
    }

    public int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }

    public static void main(String[] args) {
        LeetCode_338 lc = new LeetCode_338();
        System.out.println(lc.tableSizeFor(7));
    }
}
