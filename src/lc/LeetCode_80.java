package lc;

/**
 * 删除有序数组中的重复项 II
 * @author wei.liang
 * @since 2021/4/6
 */
public class LeetCode_80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int slow = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[slow] == nums[i] && count != 2) {
                nums[slow + 1] = nums[i];
                count++;
                slow++;
                continue;
            }
            if (nums[slow] != nums[i]) {
                nums[slow + 1] = nums[i];
                slow++;
                count = 1;
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        LeetCode_80 lc = new LeetCode_80();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        lc.removeDuplicates(nums);
    }

}
