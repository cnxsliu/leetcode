package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/11 20:29
 * @strategy BSF
 * >> 定义一个 LinkedList 用来存放每一层的节点
 * >> 对 LinkedList 进行迭代遍历，在此过程中进行核心处理，同时加入下一层节点
 * >> while 终止条件是 LinkedList.size() > 0
 */
public class L107 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.addLast(root);
        while (nodeList.size() > 0) {
            List<Integer> temp = new ArrayList<>();
            int len = nodeList.size();
            //终止条件必须是固定值，不能用 i < nodeList.size()
            for (int i = 0; i < len; i++) {
                TreeNode node = nodeList.pollFirst();
                temp.add(node.val);
                if (node.left != null) {
                    nodeList.addLast(node.left);
                }
                if (node.right != null) {
                    nodeList.addLast(node.right);
                }
            }
            res.add(0, temp);
        }
        return res;
    }
}
