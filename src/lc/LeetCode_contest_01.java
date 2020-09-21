package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Levi
 * @date 2020.9.19
 */
public class LeetCode_contest_01 {
    public boolean isMagic(int[] target) {
        int n = target.length;
        int[] init = new int[target.length];
        for(int i = 0; i < n; i++) {
            init[i] = i + 1;
        }
        for(int k = 1; k <= n; k++){
            List<Integer> tmp = new ArrayList<>();
            int[] afterAdjust = init;
            while(k < afterAdjust.length) {
                afterAdjust = helper(afterAdjust);
                for(int i = 0; i < k; i++) {
                    tmp.add(afterAdjust[i]);
                }
                int[] t = new int[afterAdjust.length - k];
                System.arraycopy(afterAdjust, k, t, 0, afterAdjust.length - k);
                afterAdjust = t;
            }
            for (int i = 0; i < afterAdjust.length; i++) {
                tmp.add(afterAdjust[i]);
            }
            int[] res = new int[target.length];
            for(int i = 0; i < target.length; i++) {
                res[i] = tmp.get(i);
            }
            if (Arrays.equals(target, res)) {
                return true;
            }

        }
        return false;
    }

    private int[] helper(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++) {
            if(i % 2 == 0) {
                even.add(nums[i - 1]);
            } else {
                odd.add(nums[i - 1]);
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i < even.size()) {
                res[i] = even.get(i);
            } else {
                res[i] = odd.get(i - even.size());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_contest_01 l = new LeetCode_contest_01();
        int[] t = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49,51,55,59,63,67,53,57,61,65,69};
        l.isMagic(t);
    }
}
