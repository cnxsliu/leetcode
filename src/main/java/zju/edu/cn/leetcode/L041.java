package zju.edu.cn.leetcode;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/23 21:27
 * @strategy 一次迭代
 */
public class L041 {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 1;
        }
        Arrays.sort(nums);
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (i >= 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] != count) {
                    return count;
                }
                count++;
            }
        }
        return nums[nums.length - 1] > 0 ? nums[nums.length - 1] + 1 : 1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,3,1};
        int[] arr2 = {1,2,0};
        System.out.println(firstMissingPositive(arr2));
    }
}
