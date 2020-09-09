package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/12 19:36
 * @strategy 递归
 */
public class L112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum , 0);
    }

    private boolean dfs(TreeNode root, int sum, int curSum) {
        // 当左右节点都为空时，表示为叶子节点
        if (root.left == null && root.right == null) {
            return curSum + root.val == sum;
        }
        // 分别对左右子树进行讨论，并对各自结果进行合并
        boolean left = false, right = false;
        if (root.left != null) {
            left = dfs(root.left, sum, curSum + root.val);
        }
        if (root.right != null) {
            right = dfs(root.right, sum, curSum + root.val);
        }
        return left || right;
    }
}
