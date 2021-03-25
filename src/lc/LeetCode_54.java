package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author wei.liang
 * @since 2021/3/15
 */
public class LeetCode_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0)
            return res;

        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length - 1; //行
        int colEnd = matrix[0].length - 1; //列


        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            //从左往右
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++; //处理完一行后往下移一行

            //从上往下
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--; //处理完一列往前移一列

            //从右往左
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }

            //从下往上
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
                colBegin++;
            }

        }
        return res;
    }

}
