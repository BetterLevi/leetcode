package lc;

import java.util.Stack;

/**
 * 二叉树遍历
 *
 * @author Levi
 * @date 2020.9.21
 */
public class LeetCode_538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        root.val += sum;
        sum = root.val;
        helper(root.left);
    }

    public TreeNode convertBST_iterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int tmp = cur.val;
            cur.val += sum;
            sum += tmp;
            cur = cur.left;
        }
        return root;
    }

}
