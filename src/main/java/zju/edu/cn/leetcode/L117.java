package zju.edu.cn.leetcode;

import java.util.LinkedList;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/13 15:56
 * @strategy BFS
 * >> 跟上一题解答完全一样
 */
public class L117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> nodeList = new LinkedList<>();
        nodeList.addLast(root);
        while (nodeList.size() > 0) {
            int len = nodeList.size();
            for (int i = 0; i < len; i++) {
                Node left = nodeList.poll();
                if (i == len - 1) {
                    left.next = null;
                } else {
                    Node right = nodeList.peek();
                    left.next = right;
                }
                if (left.left != null) {
                    nodeList.addLast(left.left);
                }
                if (left.right != null) {
                    nodeList.addLast(left.right);
                }
            }
        }
        return root;
    }
}













