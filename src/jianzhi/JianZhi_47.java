package jianzhi;

/**
 * 礼物的最大价值
 * @author Levi
 * @date 2020.8.11
 */
public class JianZhi_47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for(int j = 1; j< n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(grid[i][j] + dp[i -1][j], grid[i][j] + dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public int maxValue_withNoTable(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) {
                    grid[i][j] += grid[i][j - 1] ;
                }
                else if(j == 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
