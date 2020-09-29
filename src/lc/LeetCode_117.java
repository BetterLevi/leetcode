package lc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Levi
 * @date 2020.9.28
 */
public class LeetCode_117 {

    public Node connect(Node root) {

        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            Node pre = null;
            while (size != 0) {
                Node cur = stack.pop();
                cur.next = pre;
                pre = cur;
                size--;
                if (cur.right != null) {
                    stack.offer(cur.right);
                }
                if (cur.left != null) {
                    stack.offer(cur.left);

                }

            }
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}


