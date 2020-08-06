import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍III
 * @author Levi
 * @date 2020.8.5
 */
public class LeetCode_337 {
    public int rob(TreeNode root) {
        //备忘录
        Map<TreeNode, Integer> memo = new HashMap<>();
        return rob_help(root, memo);
    }

    private int rob_help(TreeNode root, Map<TreeNode, Integer> memo) {
        if(root == null) {
            return 0;
        }

        if (memo.get(root) != null) {
            return memo.get(root);
        }
        int rob = root.val +
                (root.left == null ? 0 : rob_help(root.left.left, memo) + rob_help(root.left.right, memo)) +
                (root.right == null ? 0 : rob_help(root.right.left, memo) + rob_help(root.right.right, memo));
        int noRob = rob_help(root.left, memo) + rob_help(root.right, memo);
        int res = Math.max(rob, noRob);
        memo.put(root, res);
        return res;
    }

    //res[0]表示不抢root结点 res[1]表示抢root结点
    public int rob_bet(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int rob = root.val + left[0] + right[0];
        int noRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{noRob, rob};
    }


}
