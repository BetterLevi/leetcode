package lc;

import java.util.Arrays;

/**
 * merge two sorted array
 *
 * @author Levi
 * @date 2020.6.4
 */
public class LeetCode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        sort(nums1, 0, n + m - 1);
    }

    public void sort(int[] nums, int low, int high) {
        if (low < high) {
            int p = getPosition(nums, low, high);
            sort(nums, low, p - 1);
            sort(nums, p + 1, high);
        }

    }

    public int getPosition(int[] nums, int low, int high) {
        int p = nums[low];
        while(low < high) {
            while (low < high && p < nums[high]) high--;
            nums[low] = nums[high];
            while (low < high && p > nums[low]) low++;
            nums[high] = nums[low];
        }
        nums[low] = p;
        return low;
    }

    public void merge_ans(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = n + m - 1;
        while (i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
