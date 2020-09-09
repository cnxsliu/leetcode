package zju.edu.cn.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/9 16:40
 * @strategy 递归 + 迭代
 * >> 注意返回结果是 Link<TreeNode>， 注意 null 和 [] 区别
 */
public class L095 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generate(1, n);
    }

    private LinkedList<TreeNode> generate(int start, int end) {
        //递归的每一层都设置一个链表集合，用来保存该层的所有结果
        LinkedList<TreeNode> all = new LinkedList<>();
        if (start > end) {
            all.add(null);
            return all;
        }
        for (int i = start; i <= end; i++) {
            //分别在 i 的左右两边进行迭代
            LinkedList<TreeNode> left = generate(start, i - 1);
            LinkedList<TreeNode> right = generate(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    all.add(root);
                }
            }
        }
        return all;
    }
}
