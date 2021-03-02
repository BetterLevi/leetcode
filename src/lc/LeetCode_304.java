package lc;

/**
 * @author wei.liang
 * @since 2021/3/2
 */
public class LeetCode_304 {

    int[][] matrix;
    int[][] sums;

    public LeetCode_304(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0) {
            this.sums = new int[0][0];
        } else {
            this.sums = new int[matrix.length][matrix[0].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    sums[i][j] = matrix[i][j];
                    continue;
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    int tmp = sums[i - 1][j];
                    int k = j;
                    while (k >= 0) {
                        tmp += matrix[i][k];
                        k--;
                    }
                    sums[i][j] = tmp;
                } else if (i - 1 >= 0) {
                    sums[i][j] = sums[i - 1][j] + matrix[i][j];
                } else {
                    sums[i][j] = sums[i][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sums.length == 0) {
            return 0;
        }
        if (row1 - 1 >= 0 && col1 - 1 >= 0) {
            return sums[row2][col2] - sums[row2][col1 - 1] - sums[row1 - 1][col2] + sums[row1 - 1][col1 - 1];
        }

        return sums[row2][col2] - sums[row1][col1] + matrix[row1][col1];

    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{12,13,14,15}};
        LeetCode_304 lc = new LeetCode_304(nums);
        lc.sumRegion(0,0,2,2);
    }
}
