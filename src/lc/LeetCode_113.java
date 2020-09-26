package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Levi
 * @date 2020.9.26
 */
public class LeetCode_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(root, sum, res, path);
        return res;
    }

    private void backTrack(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == sum)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if (root.left != null) {
            backTrack(root.left, sum - root.val, res, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            backTrack(root.right, sum - root.val, res, path);
            path.remove(path.size() - 1);
        }
    }
}
