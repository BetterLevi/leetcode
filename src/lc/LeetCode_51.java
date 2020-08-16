package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 * @author Levi
 * @date 2020.8.16
 */
public class LeetCode_51 {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        backTrack(board, 0);
        return res;
    }

    /**
     * 路径：棋盘中所有小于row的行都成功放置了皇后
     * 选择列表：第row行的所有列都是可以放置皇后的可选位置
     * 结束条件：row超出棋盘范围
     *
     * @param board 棋盘
     * @param row 行号
     */
    private void backTrack(String[][] board, int row) {
        if (row == board.length) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                tmp.add(String.join("", board[i]));
            }
            res.add(tmp);
            return;
        }
        int choose = board.length;
        for (int col = 0; col < choose; col++) {
            //排除不合法的选择
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = "Q";
            backTrack(board, row + 1);
            board[row][col] = ".";
        }
    }

    private boolean isValid(String[][] board, int row, int col) {
        int n = board.length;
        //检查列
        for (int i = 0; i < n; i++) {
            if (board[i][col].equals("Q")) {
                return false;
            }
        }
        //检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][i].equals("Q")) {
                return false;
            }
        }
        //检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_51 leetCode_51 = new LeetCode_51();
        System.out.println(leetCode_51.solveNQueens(4));
    }
}
