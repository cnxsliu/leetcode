package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/16 15:29
 * @strategy DFS
 * >> 三个 if 判断：叶子节点，左子树，右子树
 */
public class L129 {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return total;
    }

    private void dfs(TreeNode root, int sum) {
        sum = sum * 10;
        sum += root.val;
        // 叶子节点
        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }
        // 左子树
        if (root.left != null) {
            dfs(root.left, sum);
        }
        // 右子树
        if(root.right != null) {
            dfs(root.right, sum);
        }
    }
}
