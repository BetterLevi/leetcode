import java.util.LinkedList;
import java.util.List;

/**
 * 不同的二叉搜索树
 * @author Levi
 * @date 2020.7.21
 */
public class LeetCode_95 {
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        System.out.println("start index is:" + start + ", end index is:" + end);
        if(start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            for (TreeNode l : left) {
                if (l == null) {
                    System.out.println("left node : " + "null" + " ");
                } else {
                    System.out.println("left node : " + l.getVal() + " ");
                }
            }
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode r : right) {
                if (r == null) {
                    System.out.println("right node : " + "null" + " ");
                } else {
                    System.out.println("right node : " + r.getVal() + " ");
                }
            }
            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    int lval = lnode == null ? -1 : lnode.getVal();
                    int rval = rnode == null ? -1 : rnode.getVal();
                    System.out.println("root " + i + " add left : " + lval + "  add right : " + rval);
                    root.left = lnode;
                    root.right = rnode;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        generateTrees(3);
    }
}
