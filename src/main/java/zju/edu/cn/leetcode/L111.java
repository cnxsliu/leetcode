package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/12 17:33
 * @strategy
 */
public class L111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左右子树都为空，返回 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 计算左右子树的最小节点
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(min, minDepth(root.left));
        }
        if (root.right != null) {
            min = Math.min(min, minDepth(root.right));
        }
        // 加 1 表示算上本层节点
        return min + 1;
    }
}
