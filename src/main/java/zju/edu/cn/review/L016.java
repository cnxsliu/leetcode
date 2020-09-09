package zju.edu.cn.review;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @date 2020/6/29 17:50
 * 控制单一位置 + 双指针 + 迭代
 */
public class L016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        int min = Math.abs(ans - target);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) <= min) {
                    min = Math.abs(sum - target);
                    ans = sum;
                }
                if (min == 0) {
                    return ans;
                } else if (sum > target){
                    right--;
                } else if (sum < target){
                    left++;
                }
            }
        }
        return ans;
    }
}
