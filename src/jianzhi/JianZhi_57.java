package jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * two sum
 * @author Levi
 * @date 2020.9.8
 */
public class JianZhi_57 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sum = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(sum.containsKey(nums[i])) {
                return new int[]{sum.get(nums[i]), nums[i]};
            }
            sum.put(target - nums[i], nums[i]);
        }
        return new int[2];
    }

    //数组有序
    public int[] twoSum_bet(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i != j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{nums[i], nums[j]};
            }
            if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[2];
    }
}
