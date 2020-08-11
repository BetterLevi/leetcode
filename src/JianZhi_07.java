import java.util.HashMap;
import java.util.Map;

/**
 * 已知先序遍历和中序遍历 重建二叉树
 * @author Levi
 * @date 2020.8.8
 */
public class JianZhi_07 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if(inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        int index = 0;
        while(index < inorder.length) {
            if(root.val == inorder[index]) {
                break;
            }
            index++;
        }
        int len = preorder.length;
        if(index == 0) {
            root.left = null;
            int[] right = new int[len - 1];
            int[] inOrd = new int[len - 1];
            System.arraycopy(preorder, 1, right, 0, len - 1);
            System.arraycopy(inorder, 1, inOrd, 0, len - 1);
            root.right = buildTree(right, inOrd);
            return root;
        }

        if(index == len) {
            root.right = null;
            int[] left = new int[len - 1];
            int[] inOrd = new int[len - 1];
            System.arraycopy(preorder, 0, left, 0, len - 1);
            System.arraycopy(inorder, 0, inOrd, 0, len - 1);
            root.left = buildTree(left, inOrd);
            return root;
        }

        int[] left = new int[index];
        int[] right = new int[len - index - 1];
        System.arraycopy(inorder, 0, left, 0, left.length);
        System.arraycopy(inorder, index + 1, right, 0, right.length);
        int[] leftPre = new int[index];
        int[] rightPre = new int[len - index - 1];
        System.arraycopy(preorder, 1, leftPre, 0, index);
        System.arraycopy(preorder, index + 1, rightPre, 0, len - index - 1);
        root.left = buildTree(leftPre, left);
        root.right  = buildTree(rightPre, right);
        return root;
    }

    public TreeNode buildTree_bet(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }
}
