package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 克隆图
 *
 * @author Levi
 * @date 2020.8.12
 */
public class LeetCode_133 {

    private static Map<Integer, Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) {
            return null;
        }
        if (node.neighbors.isEmpty()) {
            return new Node(node.val);
        }
        if (nodes.get(node.val) != null) {
            return nodes.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        nodes.put(node.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor));
        }
        return newNode;
    }

}
