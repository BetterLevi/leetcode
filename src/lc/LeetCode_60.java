package lc;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 第k个排列
 * @author Levi
 * @date 2020.9.5
 */
public class LeetCode_60 {

    private int K;

    /**
     * 最坏时间复杂度O(n!)
     * 需要剪枝
     * @param n 1 - 9
     * @param k 1 - n!
     * @return kth
     */
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            nums.add(i);
        }
        K = k;
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        combination(nums, builder, res);
        return res.get(k - 1);
    }

    private void combination(List<Integer> nums, StringBuilder builder, List<String> res) {
        if (nums.size() == 0) {
            res.add(builder.toString());
            K--;
            return;
        }
        if (K == 0) {
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            Integer tmp = nums.get(i);
            builder.append(tmp);
            nums.remove(tmp);
            combination(nums, builder, res);
            nums.add(i, tmp);
            builder.delete(builder.length() - 1, builder.length());
        }
    }


    public String getPermutation_bet(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return String.valueOf(sb);
    }
}
