package zju.edu.cn.leetcode;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/11 16:47
 * @strategy 递归
 * >> 使用前序遍历来找到根结点的值，使用中序遍历来对左右子树进行切分
 */
public class L105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, preorder.length));
            }
        }
        return root;
    }
}
