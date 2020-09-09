package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/21 17:33
 * @strategy 二分查找的变形题。
 * >> 通过start, mid, end的条件判断，来实现二分查找
 * >> 再内部分类讨论时，通过if做一个情况的判断，else直接处理另一个个更加复杂的情况
 */
public class L033 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {4,5,6,7,0,1,2};
        System.out.println(search(array, 0));
    }
}
