package lc;

/**
 * 132模式
 * @author wei.liang
 * @since 2021/3/24
 */
public class LeetCode_456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] tmp = new int[3];
        tmp[0] = nums[0];
        tmp[1] = nums[1];
        tmp[2] = nums[2];
        for (int i = 3; i < nums.length; i++) {
            if (tmp[0] < tmp[1] && tmp[0] < tmp[2] && tmp[2] < tmp[1]) {
                return true;
            }
            tmp[0] = tmp[1];
            tmp[1] = tmp[2];
            tmp[2] = nums[i];
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode_456 lc = new LeetCode_456();
        int[] nums = {3,5,0,3,4};
        lc.find132pattern(nums);
    }
}
