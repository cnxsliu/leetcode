package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/5 17:11
 * @strategy 二分查找的变形
 */
public class L081 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0 ) {
            return false;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return true;
            }else {
                return false;
            }
        }
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                idx = i;
                break;
            }
        }
        int[] arr = new int[nums.length];
        for (int i = idx; i < nums.length; i++) {
            arr[i - idx] = nums[i];
        }
        for (int i = 0 ; i < idx; i++) {
            arr[i + nums.length - idx] = nums[i];
        }
        return binarySearch(0, arr.length - 1, arr, target);

    }

    private boolean binarySearch(int left, int right, int[] nums, int target) {
        if (nums[left] > target || nums[right] < target || left > right) {
            return false;
        }
        if (nums[left] == target || nums[right] == target) {
            return true;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] == target) {
            return true;
        } else if(nums[mid] > target) {
            return binarySearch(left + 1, mid, nums, target);
        } else {
            return binarySearch(mid, right - 1, nums, target);
        }
    }

    public static void main(String[] args) {
        L081 L = new L081();
        int[] nums = {1,2};
        System.out.println(L.search(nums, 2));
    }
}
