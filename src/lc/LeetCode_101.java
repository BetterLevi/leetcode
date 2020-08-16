package lc;

import java.util.Stack;

/**
 * 判断镜像二叉树
 *
 * @author Levi
 * @date 2020.6.7
 */
public class LeetCode_101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return symmetric(left.left, right.right) & symmetric(left.right, right.left);
    }

    public boolean isSymmetric_iteratively(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }

}
