package zju.edu.cn.leetcode;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/11 17:19
 * @strategy
 */
public class L106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null ||postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length),Arrays.copyOfRange(postorder,i, inorder.length - 1));
            }
        }
        return root;
    }
}
