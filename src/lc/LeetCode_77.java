package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Levi
 * @date 2020.9.8
 */
public class LeetCode_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backTracking(res, comb, 0, n, k);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> combination,
                              int start, int len, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < len; i++) {
            combination.add(i);
            backTracking(res, combination, i + 1, len, k - 1);
            combination.remove(combination.size() - 1);
        }
    }
}
