package jianzhi;

import java.util.Arrays;

/**
 * 判断输入的数组是否为某个二叉搜索树后序遍历的结果
 *
 * @author wei.liang
 * @since 2021/2/8
 */
public class JianZhi_33 {
    //二叉搜索树中序遍历的结果为有序数组
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 3) {
            return true;
        }
        int[] midOrder = Arrays.copyOf(postorder, postorder.length);
        Arrays.sort(midOrder);
        return helper(postorder, midOrder);
    }

    private boolean helper(int[] postorder, int[] midOrder) {
        if (postorder.length == 1 && midOrder.length == 1) {
            return postorder[0] == midOrder[0];
        }
        int root = postorder[postorder.length - 1];
        for (int i = 0; i < midOrder.length; i++) {
            if (midOrder[i] == root) {
                int[] left = Arrays.copyOfRange(midOrder, 0, i);
                int[] right = Arrays.copyOfRange(midOrder, i + 1, midOrder.length);
                int[] leftPost = Arrays.copyOfRange(postorder, 0, i);
                int[] rightPost = Arrays.copyOfRange(postorder, i, postorder.length - 1);
                if (left.length == 1 && right.length == 1) {
                    return left[0] == leftPost[0] && right[0] == rightPost[0];
                }
                if (left.length == 1 && right.length == 0) {
                    return left[0] == leftPost[0];
                }
                if (right.length == 1 && left.length == 0) {
                    return right[0] == rightPost[0];
                }
                if (left.length == 0) {
                    return helper(rightPost, right);
                }
                if (right.length == 0) {
                    return helper(leftPost, left);
                }
                return helper(leftPost, left) && helper(rightPost, right);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] p = {1,2,5,10,6,9,4,3};
        JianZhi_33 jz = new JianZhi_33();
        System.out.println(jz.verifyPostorder(p));
    }
}
