/**
 * @author Levi
 * @date 2020.3.3
 */
public class LeetCode_27 {
    public int removeElement(int[] nums, int val) {
        int m = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (nums[i] != val) {
                nums[m++] = nums[i];
            }
        }
        return m;
    }
}
