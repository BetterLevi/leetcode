package jianzhi;

import java.util.*;

/**
 * 从上到下打印二叉树 按层打印
 * @author Levi
 * @date 2020.9.11
 */
public class JianZhi_32_II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<TreeNode>> level = new HashMap<>();
        level.put(0, Arrays.asList(root));
        while (level.get(0).size() != 0) {
            List<TreeNode> tmp = level.get(0);
            List<Integer> thisLevel = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode treeNode : tmp) {
                thisLevel.add(treeNode.val);
                if (treeNode.left != null) {
                    nextLevel.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevel.add(treeNode.right);
                }
            }
            level.put(0, nextLevel);
            res.add(thisLevel);
        }
        return res;
    }

    public List<List<Integer>> levelOrder_bet(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
