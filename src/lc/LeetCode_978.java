package lc;

/**
 * 最长湍流自数组
 * @author wei.liang
 * @since 2021/2/8
 */
public class LeetCode_978 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int res = arr[0] == arr[1] ? 1 : 2;
        if (arr.length == 2) {
            return res;
        }
        int len = 1;
        for (int i = 2; i < arr.length; i++) {
            int last = arr[i - 1] - arr[i - 2];
            if ((arr[i] - arr[i - 1]) * last < 0) {
                if (len == 1) {
                    len += 2;
                } else {
                    len++;
                }
                continue;
            }
            res = Math.max(res, len);
            len = 1;
        }
        return Math.max(res, len);
    }

    public int maxTurbulenceSize_ans(int[] A) {
        int inc = 1, dec = 1, result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else if (A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(dec, inc));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        LeetCode_978 lc = new LeetCode_978();
        lc.maxTurbulenceSize(arr);
    }
}
