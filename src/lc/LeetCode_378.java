package lc;

import java.util.Arrays;

/**
 * 有序矩阵中第K小的元素
 *
 * @author Levi
 * @date 2020.7.2
 */
public class LeetCode_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int x = matrix.length;
        int[] nums = new int[x * x];
        int index = 0;
        for(int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                nums[index++] = matrix[i][j];
            }
        }
        Arrays.sort(nums);
        return nums[k - 1];
    }

    public int kthSmallest_bet(int[][] matrix, int k) {
        int x = matrix.length;
        int min = matrix[0][0];
        int max = matrix[x - 1][x - 1];
        while (min < max) {
            int count = 0;
            int j = x - 1;
            int mid = min + (max - min) / 2;
            for (int i = 0; i < x; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}
