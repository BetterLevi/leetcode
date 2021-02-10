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
        return helper(postorder, midOrder, 0, postorder.length);
    }

    private boolean helper(int[] postorder, int[] midOrder, int start, int end) {
        if (start == end - 1) {
            return postorder[start] == midOrder[start];
        }
        int root = postorder[end - 1];
        for (int i = start; i < end; i++) {
            if (midOrder[i] == root) {
                return helper(postorder, midOrder, start, i) && helper(postorder, midOrder, i + 1, end);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] p = {1,3,2,6,5};
        JianZhi_33 jz = new JianZhi_33();
        System.out.println(jz.verifyPostorder(p));
    }
}
