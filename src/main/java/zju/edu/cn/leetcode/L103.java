package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/11 14:41
 * @strategy 广度优先搜索 BFS
 * >> 每一层遍历的时候都将该层节点保存下来，在下次遍历的时候，将之前的节点取出，
 *    并根据该节点继续保存下一层的节点
 * >> 使用 LinkedList<TreeNode> 来保存每一层的节点
 * >> 使用 null 来分隔每一层的节点
 */
public class L103 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        LinkedList<Integer> levelList = new LinkedList<>();
        boolean isOrderLeft = true;
        nodeList.addLast(root);
        nodeList.addLast(null);
        while (nodeList.size() > 0) {
            TreeNode curNode = nodeList.pollFirst();
            if (curNode != null) {
                if (isOrderLeft) {
                    levelList.addLast(curNode.val);
                } else {
                    levelList.addFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeList.addLast(curNode.left);
                }
                if (curNode.right != null){
                    nodeList.addLast(curNode.right);
                }
            } else {
                res.add(levelList);
                levelList = new LinkedList<>();
                if (nodeList.size() > 0) {
                    nodeList.addLast(null);
                }
                isOrderLeft = !isOrderLeft;
            }
        }
        return res;
    }
}
