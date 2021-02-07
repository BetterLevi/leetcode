package lc;

/**
 * 判断非递减数列
 *
 * @author wei.liang
 * @since 2021/2/7
 */
public class LeetCode_665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        boolean isPoss = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            if (i > 1 && nums[i] < nums[i - 2]) {
                nums[i] = nums[i - 1];
            }
            if (!isPoss) {
                isPoss = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
