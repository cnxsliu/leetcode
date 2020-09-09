package zju.edu.cn.leetcode;

import java.util.Stack;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/12 20:29
 * @strategy 栈
 */
public class L114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            if (root.left != null && root.right != null) {
                stack.add(root.right);
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
            else if (root.left == null && root.right == null) {
                if (stack.isEmpty()) {
                    break;
                } else {
                    root.right = stack.pop();
                    root = root.right;
                }
            }
            else if (root.left != null) {
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
            else {
                root = root.right;
            }
        }
    }
}
