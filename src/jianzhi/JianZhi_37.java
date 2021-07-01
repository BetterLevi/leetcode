package jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 序列化二叉树
 * @author wei.liang
 * @since 2021/6/30
 */
public class JianZhi_37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> preTra = new ArrayList<>();
        List<Integer> midTra = new ArrayList<>();
        preTraverse(root, preTra);
        midTraverse(root, midTra);
        return preTra.toString() + "-" + midTra.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String preTra = data.split("-")[0].replace("[", "").replace("]", "");
        String midTra = data.split("-")[1].replace("[", "").replace("]", "");
        List<Integer> preTraverse = Arrays.stream(preTra.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> midTraverse = Arrays.stream(midTra.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        TreeNode root = buildTree(preTraverse, midTraverse);

        return root;
    }

    private void preTraverse(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(node.val);
        preTraverse(node.left, nodes);
        preTraverse(node.right, nodes);
    }

    private void midTraverse(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }
        midTraverse(node.left, nodes);
        nodes.add(node.val);
        midTraverse(node.right, nodes);
    }

    private TreeNode buildTree(List<Integer> preTra, List<Integer> midTra) {
        if (preTra.size() == 1) {
            return new TreeNode(preTra.get(0));
        }
        int rootVal = preTra.get(0);
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for (int i = 0; i < midTra.size(); i++) {
            if (midTra.get(i) == rootVal) {
                index = i;
                break;
            }
        }
        List<Integer> leftMid = midTra.subList(0, index);
        List<Integer> rightMid = midTra.subList(index + 1, midTra.size());
        List<Integer> leftPre = preTra.subList(1, 1 + leftMid.size());
        List<Integer> rightPre = preTra.subList(1 + leftMid.size(), preTra.size());
        root.left = buildTree(leftPre, leftMid);
        root.right = buildTree(rightPre, rightMid);
        return root;
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((char)(97));
    }
}
