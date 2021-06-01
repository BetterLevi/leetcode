package lc;

/**
 * @author wei.liang
 * @since 2021/5/28
 */
public class LeetCode_477 {

    public int totalHammingDistance_bet(int[] nums) {
        int res = 0;
        for (int i = 0; i < 30; i++) {
            int one = 0;
            for (int num : nums) {
                one += (num >> i) & 1;
            }
            res += one * (nums.length - one);
        }
        return res;
    }


    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res += hammingDistance(nums[i], nums[j]);
            }
        }
        return res;
    }

    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        int res = 0;
        while (r != 0) {
            if (r % 2 == 1) {
                res++;
            }
            r /= 2;
        }
        return res;
    }
}
