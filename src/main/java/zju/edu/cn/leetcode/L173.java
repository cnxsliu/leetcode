package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 16:56
 * @strategy 先序遍历
 */
public class L173 {
    class BSTIterator {
        List<Integer> list = new ArrayList<>();
        int index;
        public BSTIterator(TreeNode root) {
            // 需要对输入进行非空校验
            if (root != null) {
                preorder(root);
            }
            this.index = 0;
        }

        /** @return the next smallest number */
        public int next() {
            return list.get(index++);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return index < list.size();
        }

        private void preorder(TreeNode root) {
            if (root.left != null) {
                preorder(root.left);
            }
            this.list.add(root.val);
            if (root.right != null) {
                preorder(root.right);
            }
        }
    }
}
