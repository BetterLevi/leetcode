package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 公交线路
 *
 * @author wei.liang
 * @since 2021/6/28
 */
public class LeetCode_815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }
        List<int[]> starts = new ArrayList<>();
        for (int[] rt : routes) {
            List<Integer> rtList = Arrays.stream(rt).boxed().collect(Collectors.toList());
            if (rtList.contains(source) && rtList.contains(target)) {
                return 1;
            }
            if (rtList.contains(source)) {
                starts.add(rt);
            }
        }
        for (int[] start : starts) {
            int bus = 1;
            Set<int[]> visited = new HashSet<>();
            visited.add(start);
            Queue<Integer> queue = new LinkedList<>();
            for (int i : start) {
                queue.offer(i);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    if (cur == target) {
                        return bus;
                    }
                    for (int[] rt : routes) {
                        if (visited.contains(rt)) {
                            continue;
                        }
                        HashSet<Integer> rtSet = new HashSet<>();
                        for (int r : rt) {
                            rtSet.add(r);
                        }
                        if (rtSet.contains(cur)) {
                            for (int r : rtSet) {
                                queue.offer(r);
                            }
                            visited.add(rt);
                        }
                    }
                }
                bus++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] route = {{7,12}, {4,5,15}, {6}, {15,19}, {9,12,13}};
        LeetCode_815 lc = new LeetCode_815();
        System.out.println(lc.numBusesToDestination(route, 15, 12));
    }
}


































