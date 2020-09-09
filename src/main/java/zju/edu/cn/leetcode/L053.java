package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/28 20:22
 * @strategy 方法一：贪心法；方法二：归并法
 */
public class L053 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        return maxSubArrayDivideWithBorder(nums, 0, nums.length - 1);
    }

    private int maxSubArrayDivideWithBorder(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int center = start + (end - start) / 2;
        //递归计算左右子序列的最大值
        int leftMax = maxSubArrayDivideWithBorder(nums, start, center);
        int rightMax = maxSubArrayDivideWithBorder(nums,center + 1, end);
        //从右向左计算包含center的最大值和
        int leftCrossMax = Integer.MIN_VALUE;
        int leftCrossSum = 0;
        for (int i= center; i >= start; i--) {
            leftCrossSum += nums[i];
            leftCrossMax = Math.max(leftCrossSum,leftCrossMax);
        }
        //从左向右计算包含center + 1的最大值和
        int rightCrossMax = nums[center + 1];
        int rightCrossSum = 0;
        for (int i = center + 1; i <= end; i++) {
            rightCrossSum += nums[i];
            rightCrossMax = Math.max(rightCrossMax, rightCrossSum);
        }
        //计算横跨中心的两个子序列的最大值
        int crossMax = leftCrossMax + rightCrossMax;
        //返回三个最大值中的最大值
        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }
}
