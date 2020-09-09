package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/11 16:17
 * @strategy 深度优先 ：DFS
 */
public class L104 {
    public int maxDepth(TreeNode root) {
        return helper(root, 1);
    }

    private int helper(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        return Math.max(helper(root.left, depth + 1), helper(root.right, depth + 1));
    }
}
