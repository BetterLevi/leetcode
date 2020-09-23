package lc;

/**
 * 合并二叉树
 * @author Levi
 * @date 2020.9.23
 */
public class LeetCode_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        helper(t1, t1, t2, true);
        return t1;

    }

    private void helper(TreeNode par, TreeNode t1, TreeNode t2, boolean isLeft) {
        if(t1 == null && t2 == null) {
            return;
        }
        if(t1 == null && t2 != null) {
            if(isLeft) {
                par.left = t2;
            } else {
                par.right = t2;
            }
            return;
        }
        if(t1 != null && t2 == null) {
            return;
        }
        t1.val += t2.val;
        helper(t1, t1.left, t2.left, true);
        helper(t1, t1.right, t2.right, false);
    }

    public TreeNode mergeTrees_bet(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null && t2 != null) {
            return t2;
        }
        if (t1 != null && t2 == null) {
            return t1;
        }
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
