import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Levi
 * @date 2020.7.7
 */
public class LeetCode_112 {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null && 0 == sum) {
            return true;
        }
        boolean left = hasPathSum(root.left, sum);
        boolean right = hasPathSum(root.right, sum);
        return  left || right;
    }

    public static void main(String[] args) {
        List<Integer> r = new ArrayList<>();
        r.add(0);
        Integer[] rr = (Integer[]) r.toArray();
        Arrays.sort(rr);
        r.sort(Comparator.comparing(Integer::new));
        TreeNode sev = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode ele = new TreeNode(11);
        ele.left = sev;
        ele.right = two;
        TreeNode fou = new TreeNode(4);
        fou.left = ele;
        TreeNode root = new TreeNode(5);
        root.left = fou;
        TreeNode eig = new TreeNode(8);
        TreeNode tid = new TreeNode(13);
        eig.left = tid;
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        four.right = one;
        eig.right = four;
        root.right = eig;
        hasPathSum(root, 22);
    }
}
