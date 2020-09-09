package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/16 20:33
 * @strategy DFS
 * >> 使用 BFS 速度差不多，但是不需要递归得更深
 * >> 如果使用 BFS，会占用更多内存
 */
public class L133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node nodeClone = new Node(node.val, new ArrayList<>());
        visited.put(node, nodeClone);
        for (Node neighbor : node.neighbors) {
            nodeClone.neighbors.add(cloneGraph(neighbor));
        }
        return nodeClone;
    }

}















