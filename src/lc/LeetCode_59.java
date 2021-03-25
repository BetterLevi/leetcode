package lc;

/**
 * 螺旋矩阵II
 * @author wei.liang
 * @since 2021/3/16
 */
public class LeetCode_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int index = 1;
        int left = 0;
        int right = n;
        int col = 0;
        while (left < right) {
            //from left to right
            for (int i = left; i < right; i++) {
                res[col][i] = index++;
            }
            //from top to bottom
            for (int i = col + 1; i < n - col; i++) {
                res[i][n - col - 1] = index++;
            }
            //from right to left
            for (int i = n - col - 2; i > col ; i--) {
                res[n - col - 1][i] = index++;
            }
            //from bottom to top
            for (int i = n - col - 1; i > col; i--) {
                res[i][col] = index++;
            }
            left++;
            right--;
            col++;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_59 lc = new LeetCode_59();
        lc.generateMatrix(3);
    }
}
