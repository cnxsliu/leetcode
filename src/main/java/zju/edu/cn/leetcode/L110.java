package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/12 15:54
 * @strategy 前序遍历
 * >>
 */
public class L110 {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        //遍历到 null，返回 0
        if (root == null) {
            return 0;
        }
        //如果左右子树为 -1，则直接返回 -1
        int left = recur(root.left);
        if (left == - 1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == - 1) {
            return -1;
        }
        //取出左右子树中高度最大的一个再加一
        return Math.abs(left - right) >= 2 ? -1 : Math.max(left, right) + 1;
    }

    /**
     * 自己写的，无法通过
     */
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        depth(root, 0);
        if (max - min > 1) {
            return false;
        } else {
            return true;
        }
    }

    private void depth(TreeNode root, int level) {
        if (root == null) {
            min = Math.min(level, min);
            max = Math.max(level, max);
            return;
        }
        if (root.left == null && root.right == null) {
            min = Math.min(min, level);
            max = Math.max(max, level );
            return;
        }
        if (root.left != null) {
            depth(root.left, level + 1);
        }
        if (root.right != null) {
            depth(root.right, level + 1);
        }
    }
}
