package lc;

/**
 * 判断平衡二叉树
 *
 * @author Levi
 * @date 2020.7.6
 */
public class LeetCode_110 {
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];
    }

    private int getHeight(TreeNode root, int level, boolean[] res) {
        if (root == null) {
            return level;
        }
        int lh = getHeight(root.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rh = getHeight(root.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lh - rh) > 1) {
            res[0] = false;
        }
        return Math.max(lh, rh);
    }
}
