package jianzhi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 * @author Levi
 * @date 2020.10.14
 */
public class JianZhi_17_14 {

    public int[] smallestK2(int[] arr, int k) {
        if(arr.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for(int t : arr) {
            if (maxHeap.size() <k) {
                maxHeap.add(t);
            } else {
                if (maxHeap.peek() > t) {
                    maxHeap.poll();
                    maxHeap.add(t);
                }
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;

    }

    public int[] smallestK1(int[] arr, int k) {
        if(arr.length == 0 || k == 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public int[] smallestK(int[] arr, int k) {
        if(arr.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for(int t : arr) {
            minHeap.add(t);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}
