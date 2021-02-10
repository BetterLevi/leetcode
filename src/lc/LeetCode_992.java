package lc;

import java.util.*;

/**
 * @author wei.liang
 * @since 2021/2/9
 */
public class LeetCode_992 {

    public int subarraysWithKDistinct(int[] A, int K) {
            int res = 0;
            int len = K;
            while (len <= A.length) {
                List<Integer> nums = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    nums.add(A[i]);
                }
                if (isAllDiff(nums, K)) {
                    res++;
                }
                for (int i = len; i < A.length; i++) {
                    nums.remove(0);
                    nums.add(A[i]);
                    if (isAllDiff(nums, K)) {
                        res++;
                    }
                }
                len++;
            }
            return res;
    }

    private boolean isAllDiff(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>(nums);
        return k == set.size();
    }

    public static void main(String[] args) {
        LeetCode_992 lc = new LeetCode_992();
        int[] A = {1,2,1,2,3};
        lc.subarraysWithKDistinct(A, 2);
    }
}
