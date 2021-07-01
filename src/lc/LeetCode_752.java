package lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 打开转盘锁
 *
 * @author wei.liang
 * @since 2021/6/27
 */
public class LeetCode_752 {

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> path = new LinkedList<>();
        path.offer("0000");
        int step = 0;
        while (!path.isEmpty()) {
            int size = path.size();
            for (int s = 0; s < size; s++) {
                String p = path.poll();
                if (visited.contains(p)) {
                    continue;
                }
                if (target.equals(p)) {
                    return step;
                }
                for (int i = 0; i < 4; i++) {
                    String up = upward(p, i);
                    path.offer(up);
                    String down = downward(p, i);
                    path.offer(down);
                }
                visited.add(p);
            }
            step++;
        }
        return step;
    }

    private String upward(String path, int index) {
        char[] pc = path.toCharArray();
        if (pc[index] == '0') {
            pc[index] = '9';
            return new String(pc);
        }
        pc[index]--;
        return new String(pc);
    }

    private String downward(String path, int index) {
        char[] pc = path.toCharArray();
        if (pc[index] == '9') {
            pc[index] = '0';
            return new String(pc);
        }
        pc[index]++;
        return new String(pc);
    }


}
