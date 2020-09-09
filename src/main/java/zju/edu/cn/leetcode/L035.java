package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/22 14:02
 * @strategy 二分查找
 * >> 中间值如果和目标值相等，直接返回中间值
 * >> 二分查找的总体框架不变，在各个判断区间，进行分类讨论，主要是对左右位置元素大小的判断
 * >> 注意数组下标越界前的拦截判断
 */
public class L035 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                if (mid == 0) {
                    return 0;
                }
                if (nums[mid - 1] > target) {
                    right = mid - 1;
                    if (right < 0) {
                        return 0;
                    }
                } else if(nums[mid - 1] < target){
                    return mid;
                } else if (nums[mid - 1] == target){
                    return mid - 1;
                }
            }
            else if (nums[mid] < target) {
                if (mid == nums.length - 1) {
                    return nums.length;
                }
                if (nums[mid + 1] < target) {
                    left = mid + 1;
                    if (left > nums.length - 1) {
                        return left;
                    }
                }
                else if (nums[mid + 1] >= target){
                    return mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println((0 +1) / 2);
    }
}
