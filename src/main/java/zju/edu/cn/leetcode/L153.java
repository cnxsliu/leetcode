package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/24 15:57
 * @strategy 二分查找
 * >> 该解法并不通用，必须让 middle 与 right 进行比较，right 和 left 的赋值也很技巧，因为和
 *    取商的结果有关
 */
public class L153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[right]) {
                // middle可能是最小值
                right = middle;
            } else {
                // middle肯定不是最小值
                left = middle + 1;
            }
        }
        return nums[left];
    }
}
