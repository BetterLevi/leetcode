package lc;

import java.util.*;

/**
 * @author Levi
 * @date 2020.9.7
 */
public class LeetCode_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> holder = new ArrayList<>(counter.entrySet());
        holder.sort((e1, e2) -> e2.getValue() - e1.getValue());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = holder.get(i).getKey();
        }
        return res;
    }
}
