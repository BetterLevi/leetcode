package lc;

import java.util.*;

/**
 * 滑动窗口中位数
 * @author wei.liang
 * @since 2021/2/3
 */
public class LeetCode_480 {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] res = new double[len - k + 1];
        int[] window = new int[k];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        int[] tmp = Arrays.copyOf(window, k);
        Arrays.sort(tmp);
        res[0] = k % 2 == 0 ? tmp[k / 2] / 2.0 + tmp[k / 2 - 1] / 2.0 : tmp[k / 2];
        for (int i = k; i < len; i++) {
            window[i % k] = nums[i];
            tmp = Arrays.copyOf(window, k);
            Arrays.sort(tmp);
            res[i - k + 1] = k % 2 == 0 ? tmp[k / 2] / 2.0 + tmp[k / 2 - 1] / 2.0 : tmp[k / 2];
        }
        return res;
    }

    /**
     * use priority queue to solve
     */
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public double[] betterSolution(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) return new double[0];
        double[] result = new double[n];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }

        return result;
    }

    private void add(int num) {
        if (num < getMedian()) {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        }
        else {
            minHeap.remove(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
        else {
            return (double)minHeap.peek();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        LeetCode_480 lc = new LeetCode_480();
        double[] res = lc.betterSolution(nums, 3);
        System.out.println(res);
    }
}
