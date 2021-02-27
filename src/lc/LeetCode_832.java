package lc;

/**
 * @author wei.liang
 * @since 2021/2/24
 */
public class LeetCode_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = n - 1;
            while (start <= end) {
                int tmp = A[i][start];
                A[i][start] = A[i][end] == 1 ? 0 : 1;
                A[i][end] = tmp == 1 ? 0 : 1;
                start++;
                end--;
            }
        }
        return A;
    }
}
