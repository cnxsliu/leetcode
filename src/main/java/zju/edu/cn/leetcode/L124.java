package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/13 21:11
 * @strategy
 */
public class L124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 取左右两条路径和 0 的比较的最大值
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        int value = root.val + left + right;
        maxSum = Math.max(value, maxSum);
        // 返回一条路径和最大的值
        return root.val + Math.max(left, right);
    }
}
