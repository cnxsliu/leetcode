package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/12 14:40
 * @strategy 递归
 */
public class L109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return helper(arr);
    }

    private TreeNode helper(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        if (arr.length == 1) {
            return new TreeNode(arr[0]);
        }
        int mid = arr.length / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(Arrays.copyOfRange(arr, 0, mid));
        root.right = helper(Arrays.copyOfRange(arr, mid + 1, arr.length));
        return root;
    }

    private TreeNode helper(int[] arr, int left, int right) {
        if (left > right || left < 0 || right > arr.length) {
            return null;
        }
        if (left == right && right < arr.length) {
            return new TreeNode(arr[left]);
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr, left, mid);
        root.right = helper(arr, mid + 1, right);
        return root;
    }
}
