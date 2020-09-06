package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树所有路径
 *
 * @author Levi
 * @date 2020.9.4
 */
public class LeetCode_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(root.val);
        backTracking(root, builder, res);
        return res;
    }

    private void backTracking(TreeNode root, StringBuilder builder, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(builder.toString());
            return;
        }
        List<TreeNode> child = new ArrayList<>();
        if (root.left != null) {
            child.add(root.left);
        }
        if (root.right != null) {
            child.add(root.right);
        }
        for (TreeNode c : child) {
            builder.append("->").append(c.val);
            backTracking(c, builder, res);
            builder.delete(builder.lastIndexOf("->"), builder.length());
        }
    }

    private void dfs(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        if (root.left != null) {
            dfs(root.left, path + root.val + "->", res);
        }
        if (root.right != null) {
            dfs(root.right, path + root.val + "->", res);
        }

    }
}
