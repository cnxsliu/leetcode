package zju.edu.cn.leetcode;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/24 20:12
 * @strategy 排序 + 迭代
 */
public class L164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int maxGap = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
        }
        return maxGap;
    }
}
