package lc;

/**
 *
 * @author Levi
 * @date 2020.7.8
 */
public class LeetCode_16_11 {
    public static int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0) {
            return new int[0];
        }
        if(shorter == longer) {
            int[] res = new int[1];
            res[0] = shorter * k;
            return res;
        }
        int[] res = new int[k + 1];
        int index = 0;
        for(int i = 0; i <= k; i++) {
            int len = shorter * (k - i) + longer * i;
            res[index++] = len;
        }
        return res;
    }
}
