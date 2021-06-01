package lc;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找出第 K 大的异或坐标值
 *
 * @author wei.liang
 * @since 2021/5/19
 */
public class LeetCode_1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        PriorityQueue<Integer> nums = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ matrix[i][j];

                } else if (i - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j] ^ matrix[i][j];
                } else {
                    dp[i][j] = dp[i][j - 1] ^ matrix[i][j];
                }
                nums.add(dp[i][j]);
            }
        }
        Integer res = 0;
        while (k > 0) {
            res = nums.poll();
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test =  {{5,2}, {1,6}};
        LeetCode_1738 lc = new LeetCode_1738();
        System.out.println(lc.kthLargestValue(test, 1));
        System.out.println(5 ^ 1);
        System.out.println(5 ^ 2);
        System.out.println(4 ^ 7 ^ 6);
        System.out.println(5 ^ 1 ^ 2 ^ 6 ^ 5);
    }

}
