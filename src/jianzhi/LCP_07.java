package jianzhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wei.liang
 * @since 2021/7/1
 */
public class LCP_07 {
    int ways, n, k;
    Map<Integer, List<Integer>> edges = new HashMap<>();
    public int numWays(int n, int[][] relation, int k) {
        this.ways = 0;
        this.n = n;
        this.k = k;
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            List<Integer> next = edges.get(src) != null ? edges.get(src) : new ArrayList<>();
            next.add(dst);
            edges.put(src, next);
        }
        dfs(0, 0);
        return ways;
    }

    public void dfs(int index, int steps) {
        if (steps == k) {
            if (index == n - 1) {
                ways++;
            }
            return;
        }
        List<Integer> list = edges.get(index) == null ? new ArrayList<>() : edges.get(index);
        for (int nextIndex : list) {
            dfs(nextIndex, steps + 1);
        }
    }
}
