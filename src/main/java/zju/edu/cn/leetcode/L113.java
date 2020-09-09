package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/12 20:13
 * @strategy 递归
 * >> 对于左右子树都为空的情况，剪枝
 * >> 其余的情况都要 root.left != null 和root.right != null 进行单独判断
 */
public class L113 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        recur(root, sum, new LinkedList<>(), 0);
        return res;
    }

    private void recur(TreeNode root, int sum, LinkedList<Integer> list, int curSum) {
        list.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (curSum + root.val == sum) {
                res.add(new ArrayList<>(list));
                list.removeLast();
                return;
            }
        }
        if (root.left != null) {
            recur(root.left, sum, list, curSum + root.val);
        }
        if (root.right != null) {
            recur(root.right, sum, list, curSum + root.val);
        }
        list.removeLast();
    }
}
