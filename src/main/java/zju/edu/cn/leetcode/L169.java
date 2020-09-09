package zju.edu.cn.leetcode;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 16:28
 * @strategy
 */
public class L169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}
