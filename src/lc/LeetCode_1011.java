package lc;

import java.util.Map;

/**
 * @author wei.liang
 * @since 2021/4/26
 */
public class LeetCode_1011 {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int singleMax = 0;
        for(int i : weights) {
            sum += i;
            singleMax = Math.max(singleMax, i);
        }
        int min = singleMax;
        int max = sum;
        while(min < max - 1) {
            int mid = (min + max) / 2;
            if(possible(mid, weights, D)) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return min;
    }

    private boolean possible(int capacity, int[] weights, int D) {
        int sum = 0;
        for(int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if(sum > capacity) {
                sum = weights[i];
                D--;
            } else if (sum == capacity) {
                sum = 0;
                D--;
            }
        }
        return D > 0;
    }

    public static void main(String[] args) {
        LeetCode_1011 lc = new LeetCode_1011();
        int[] w = new int[]{1,2,3,4,5,6,7,8,9,10};
        //lc.possible(15, w, 5);
        lc.shipWithinDays(w, 5);
    }
}
