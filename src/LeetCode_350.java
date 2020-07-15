import java.util.*;

/**
 * 数组取交集
 * @author Levi
 * @date 2020.7.13
 */
public class LeetCode_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> reflect = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (reflect.containsKey(nums1[i])) {
                reflect.put(nums1[i], reflect.get(nums1[i]) + 1);
            } else {
                reflect.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (reflect.containsKey(nums2[i]) && reflect.get(nums2[i]) > 0) {
                res.add(nums2[i]);
                reflect.put(nums2[i], reflect.get(nums2[i]) - 1);
            }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
