package zju.edu.cn.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/27 17:05
 * @strategy BFS
 */
public class L199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = list.poll();
                if (i == 0) {
                    res.add(temp.val);
                }
                if (temp.right != null) {
                    list.add(temp.right);
                }
                if (temp.left != null) {
                    list.add(temp.left);
                }
            }
        }
        return res;
    }
}
