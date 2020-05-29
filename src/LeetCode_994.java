import java.util.LinkedList;
import java.util.Queue;

/**
 * rotten oranges
 *
 * @author Levi
 * @date 2020.3.4
 */
public class LeetCode_994 {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> rottenPlace = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    rottenPlace.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int count = 0;
        int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!rottenPlace.isEmpty()) {
            ++count;
            int size = rottenPlace.size();
            for (int i = 0; i < size; i++) {
                int[] rottenPoint = rottenPlace.poll();
                for (int[] dir : dirs) {
                    int x = rottenPoint[0] + dir[0];
                    int y = rottenPoint[1] + dir[1];
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 2 || grid[x][y] == 0) {
                        continue;
                    }
                    grid[x][y] = 2;
                    rottenPlace.offer(new int[]{x, y});
                    freshCount--;
                }
            }
        }
        return freshCount == 0 ? count - 1 : -1;
    }
}
