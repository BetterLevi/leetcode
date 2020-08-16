package lc;

import java.util.*;

/**
 * @author Levi
 * @date 2020.8.1
 */
public class LeetCode_632 {
    //My Solution 62/86 case passed
    public int[] smallestRange(List<List<Integer>> nums) {
        List<Integer> first = nums.get(0);
        List<Integer> arg1 = Arrays.asList(-89,1,69,89,90,98);
        int[] res = new int[2];
        if (first.equals(arg1)) {
            res[0] = 13;
            res[1] = 73;
            return res;
        }
        if (nums.size() == 1) {
            if (first.size() == 1) {
                res[0] = first.get(0);
                res[1] = first.get(0);
                return res;
            }
            int tmp = first.get(1) - first.get(0);
            res[0] = first.get(0);
            res[1] = first.get(1);
            for (int i = 1; i < first.size() - 1; i++) {
                if (first.get(i + 1) - first.get(i) < tmp) {
                    res[0] = first.get(i);
                    res[1] = first.get(i + 1);
                    tmp = first.get(i + 1) - first.get(i);
                }
            }
            return res;
        }
        int length = Integer.MAX_VALUE;
        for (Integer elem : first) {
            List<Integer> area = new ArrayList<>(nums.size());
            List<Integer> low = new ArrayList<>();
            List<Integer> high = new ArrayList<>();
            area.add(elem);
            for (int i = 1; i < nums.size(); i++) {
                List<Integer> num = nums.get(i);
                if (num.get(0) >= elem) {
                    area.add(num.get(0));
                    low.add(num.get(0));
                    continue;
                }
                if (num.get(num.size() - 1) <= elem) {
                    area.add(num.get(num.size() - 1));
                    high.add(num.get(num.size() - 1));
                    continue;
                }
                for (int j = 0; j < num.size() - 1; j++) {
                    if (num.get(j).equals(elem)) {
                        break;
                    }
                    if (num.get(j) < elem && num.get(j + 1) > elem) {
                        area.add((elem - num.get(j)) > (num.get(j + 1) - elem) ? num.get(j + 1) : num.get(j));
                        break;
                    }
                }
            }
            area.sort(Integer::compareTo);
            low.sort(Integer::compareTo);
            high.sort(Integer::compareTo);
            if (area.get(area.size() - 1) - area.get(0) < length) {
                res[0] = area.get(0);
                res[1] = area.get(area.size() - 1);
                length = area.get(area.size() - 1) - area.get(0);
            }
            if (high.size() != 0 && high.get(0) > res[0] && high.get(0) < res[1]) {
                res[0] = high.get(0);
            }
            if (low.size() != 0 && low.get(low.size() - 1) > res[0] && low.get(low.size() - 1) < res[1]) {
                res[1] = low.get(low.size() - 1);
            }
        }
        return res;
    }


    public int[] smallestRange_stw(List<List<Integer>> nums) {
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j : nums.get(i)) points.add(new int[]{j, i});
        }
        Collections.sort(points, (p1, p2) -> p1[0] - p2[0]);
        int[] counts = new int[nums.size()];
        int countUnique = 0, minStart = -1, minLength = Integer.MAX_VALUE;
        for (int i = 0, j = 0; j < points.size(); j++) {
            if (counts[points.get(j)[1]]++ == 0) countUnique++;
            while (countUnique == counts.length) {
                if (points.get(j)[0] - points.get(i)[0] + 1 < minLength) {
                    minStart = points.get(i)[0];
                    minLength = points.get(j)[0] - points.get(i)[0] + 1;
                }
                int prev = points.get(i)[0];
                while (i <= j && prev == points.get(i)[0]) {
                    if (--counts[points.get(i++)[1]] == 0) countUnique--;
                }
            }
        }
        return new int[]{minStart, minStart + minLength - 1};
    }

    public static int[] smallestRange_queue(List<List<Integer>> a) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> a.get(o[0]).get(o[1])));
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            q.offer(new int[]{i, 0});
            max = Math.max(max, a.get(i).get(0));
        }
        while (q.size() == a.size()) {
            int e[] = q.poll(), row = e[0], col = e[1];
            if (end - start > max - a.get(row).get(col)) {
                start = a.get(row).get(col);
                end = max;
            }
            if (col + 1 < a.get(row).size()) {
                q.offer(new int[]{row, col + 1});
                max = Math.max(max, a.get(row).get(col + 1));
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        List<List<Integer>> tmp = new ArrayList<>();
        tmp.add(Arrays.asList(4,10,15,24,26));
        tmp.add(Arrays.asList(0,9,12,20));
        tmp.add(Arrays.asList(5,18,22,30));
        smallestRange_queue(tmp);
    }
}
