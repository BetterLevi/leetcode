package lc;

/**
 * 多数元素
 * @author Levi
 * @date 2020.7.11
 */
public class LeetCode_169 {
    public static int majorityElement(int[] nums) {
        int left = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                left = nums[i];
            } else if (left == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return left;
    }
}
