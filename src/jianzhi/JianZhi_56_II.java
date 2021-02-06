package jianzhi;

import java.util.*;

/**
 * 数组中只有一个元素出现了一次 其他元素均出现了三次
 * 返回出现一次的元素
 *
 * @author wei.liang
 * @since 2021/2/5
 */
public class JianZhi_56_II {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int num : nums) {
            if (!store.containsKey(num)) {
                store.put(num, 1);
                continue;
            }
            if (store.get(num) + 1 == 3) {
                store.remove(num);
            } else {
                store.put(num, store.get(num) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            return entry.getKey();
        }
        return -1;
    }

}
