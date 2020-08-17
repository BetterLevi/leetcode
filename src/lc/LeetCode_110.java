package lc;

/**
 * 判断平衡二叉树
 *
 * @author Levi
 * @date 2020.7.6
 */
public class LeetCode_110 {

    public boolean res = true;

    public boolean isBalanced(TreeNode root) {
        getHeight(root, 1);
        return res;
    }

    private int getHeight(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        int lh = getHeight(root.left, level + 1);
        int rh = getHeight(root.right, level + 1);
        if (Math.abs(lh - rh) > 1) {
            res = false;
        }
        return Math.max(lh, rh);
    }

    public boolean isBalance_topDown(TreeNode node) {
        if (node == null) {
            return true;
        }
        int lh = depth(node.left);
        int rh = depth(node.right);
        return Math.abs(lh - rh) < 1 && isBalance_topDown(node.left) && isBalance_topDown(node.right);

    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    public boolean isBalance_bottomUp(TreeNode node) {
        return dfsHeight(node) != -1;
    }

    private int dfsHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = dfsHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = dfsHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
