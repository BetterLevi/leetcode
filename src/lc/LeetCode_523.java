package lc;

/**
 * 连续的子数组和
 * @author wei.liang
 * @since 2021/6/2
 */
public class LeetCode_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int window = 2;
        while (window <= nums.length) {
            int sum = 0;
            for (int i = 0; i <= nums.length - window; i++) {
                if (i == 0) {
                    for (int j = 0; j < window; j++) {
                        sum += nums[j];
                    }
                } else {
                    sum -= nums[i - 1];
                    sum += nums[i + window - 1];
                }
                if (sum % k == 0) {
                    return true;
                }
            }
            window++;
        }
        return false;
    }

    private boolean helper(int[] nums, int start, int end, int k) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum % k == 0;
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        LeetCode_523 lc = new LeetCode_523();
        lc.checkSubarraySum(nums, 1);
    }
}
