package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 与数组中元素的最大异或值
 * @author wei.liang
 * @since 2021/5/23
 */
public class LeetCode_1707 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int[] query : queries) {
            int x = query[0];
            int m = query[1];
            int q = -1;
            for (int i = 0; i < nums.length && nums[i] < m; i++) {
                q = Math.max(x ^ nums[i], q);
            }
            res.add(q);
        }
        return res.stream().mapToInt(re -> re).toArray();
    }
}
