package zju.edu.cn.leetcode;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/11 21:17
 * @strategy BFS
 */
public class L108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        //中点就是 nums.length / 2 ，不要考虑得太复杂
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 3)));
    }
}
