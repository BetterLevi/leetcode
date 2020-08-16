package lc;

/**
 * @author Levi
 * @date 2020.3.3
 */
public class LeetCode_10_01 {
    public int[] merge(int[] A, int m, int[] B, int n) {
        int[] res = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while(i < m  && j < n) {
            if(A[i] < B[j]) {
                res[index++] = A[i];
                i++;
            } else {
                res[index++] = B[j];
                j++;
            }
        }
        if(i == m) {
            for(; j < n; j++) {
                res[index++] = B[j];
            }
        }
        if(j == n) {
            for(; i < m; i++) {
                res[index++] = A[i];
            }
        }
        return res;
    }
}
