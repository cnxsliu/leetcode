package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/26 17:16
 * @strategy 数组反转
 */
public class L189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k , nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int times = k % nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i > nums.length - 1 - times; i--) {
            list.add(nums[i]);
        }
        for (int i = nums.length - 1 - times; i >= 0; i--) {
            nums[i + times] = nums[i];
        }
        for (int i = times - 1; i >= 0; i--) {
            nums[i] = list.get(times - 1 - i);
        }
    }
}
