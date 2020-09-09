package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/9 22:50
 * @strategy 递归
 * >> 主要是终止条件
 */
public class L100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return helper(p.left,q.left) && helper(p.right,q.right);
    }
}
