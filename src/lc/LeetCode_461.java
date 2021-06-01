package lc;

/**
 * 汉明距离
 * @author wei.liang
 * @since 2021/5/27
 */
public class LeetCode_461 {
    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        char[] bins = Integer.toBinaryString(r).toCharArray();
        int res = 0;
        for (char c : bins) {
            if (c == '1') {
                res++;
            }
        }
        return res;
    }

    public int hammingDistance_ano(int x, int y) {
        int r = x ^ y;
        int res = 0;
        while (r != 0) {
            if (r % 2 == 1) {
                res++;
            }
            r /= 2;
        }
        return res;
    }
}
