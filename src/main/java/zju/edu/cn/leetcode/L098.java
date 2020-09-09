package zju.edu.cn.leetcode;


/**
 * @author cnxsliu
 * @description
 * @date 2020/5/5 23:27
 * @strategy 迭代；中序遍历
 * >> 分别用一个 lower 和 upper 来维护一棵树的上界和下界
 */
public class L098 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!dfs(root.right, val, upper)) {
            return false;
        }
        if (!dfs(root.left, lower, val)) {
            return false;
        }
        return true;
    }
}
