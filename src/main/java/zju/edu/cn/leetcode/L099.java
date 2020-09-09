package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/9 19:28
 * @strategy 中序遍历 + 节点交换
 * >> 可以通过在中序遍历过程中保留 root 节点来保留前一个遍历的节点（废话）
 * >> 交换节点时是交换两个节点的值
 */
public class L099 {
    TreeNode x = null, y = null, pre = null;
    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);
    }

    private void findTwoSwapped(TreeNode root) {
        if (root == null) {
            return;
        }
        findTwoSwapped(root.left);
        //关键
        if (pre != null && pre.val > root.val) {
            y = root;
            //第一次时，x 和 y 均赋值
            if (x == null) {
                x = pre;
                //第二次时，只有 y 赋值
            } else {
                return;
            }
        }
        //保留中序遍历的前一个节点
        pre = root;
        findTwoSwapped(root.right);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
