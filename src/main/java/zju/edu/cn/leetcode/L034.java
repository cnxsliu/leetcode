package zju.edu.cn.leetcode;

import java.util.ArrayList;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/21 20:25
 * @strategy
 * 二分查找，使用二分查找分别对左右边界进行查找
 * >> 注意查找目标值等于中间值时候，边界值该如何改变
 */
public class L034 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[]{-1, -1};
        }
        int left = left_bound(nums, target);
        int right = right_bound(nums, target);
        return new int[] {left, right};
    }

    public static int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        //最后left与right会在左边界重合，然后right-1，所以应该返回left
        return left;
    }

    public static int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] <target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 5};
        int[] res = searchRange(array, 3);
        System.out.println("" + res[0] + res[1]);
        ClassLoader.getSystemClassLoader();
    }
}
