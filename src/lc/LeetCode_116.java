package lc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 连接二叉树右侧结点
 * @author Levi
 * @date 2020.10.15
 */
public class LeetCode_116 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node first = root;
        while (first.left != null) {
            Node head = first;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            first = first.left;
        }
        return root;
    }


    public Node connect_stack(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int num = q.size();
            Node pre = null;
            while (num-- != 0) {
                Node n1 = q.pop();
                n1.next = pre;
                pre = n1;
                if (n1.left != null) {
                    q.offer(n1.right);
                    q.offer(n1.left);
                }

            }
        }
        return root;
    }

    public Node connect_queue(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int num = q.size();
            while (num != 0) {
                Node n1 = q.poll();
                num--;
                if (num == 0) {
                    n1.next = null;
                } else {
                    Node n2 = q.peek();
                    n1.next = n2;
                }
                if (n1.left != null) {
                    q.offer(n1.left);
                    q.offer(n1.right);
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

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
