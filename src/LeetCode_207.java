import sun.awt.image.ImageWatched;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 拓扑排序
 * @author Levi
 * @date 2020.8.4
 */
public class LeetCode_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) {
            return true;
        }
        int[] inDegree = new int[numCourses];
        int count = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            count++;
            for (int i = 0; i < prerequisites.length; i++) {
                if (cur == prerequisites[i][1]) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        stack.push(prerequisites[i][0]);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
