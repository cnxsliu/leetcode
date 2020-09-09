package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/9 23:28
 * @strategy 递归
 * >> 通过 res.get(level).add(root.val); 来设置相应层级的节点集合
 * >> 通过 level 标签来对层级进行标记
 * >> 辅助函数不需要返回值
 */
public class L102 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }
}
