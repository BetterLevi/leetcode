import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的最大深度
 * @author Levi
 * @date 2020.7.28
 */
public class LeetCode_104 {
    public int maxDepth(TreeNode root) {
        return help(root, 0);

    }

    private int help(TreeNode root, int high) {
        if(root == null) {
            return high;
        }
        int left = help(root.left, high + 1);
        int right = help(root.right, high + 1);;
        return Math.max(left, right);
    }

    public int maxDepth_dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> high = new Stack<>();
        nodes.push(root);
        high.push(1);
        int max = 0;
        while (!nodes.isEmpty()) {
            TreeNode tmp = nodes.pop();
            int tmpHigh = high.pop();
            max = Math.max(max, tmpHigh);
            if (tmp.left != null) {
                nodes.push(tmp.left);
                high.push(tmpHigh + 1);
            }
            if (tmp.right != null) {
                nodes.push(tmp.right);
                high.push(tmpHigh + 1);
            }
        }
        return max;
    }

    public int maxDepth_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int high = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size-- > 0) {
                TreeNode tmp = nodes.poll();
                if (tmp.left != null) {
                    nodes.offer(tmp.left);
                }
                if (tmp.right != null) {
                    nodes.offer(tmp.right);
                }
            }
            high++;
        }
        return high;
    }
}
