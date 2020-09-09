package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/24 18:42
 * @strategy 迭代
 */
public class L162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        for(int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int c = 3 + (4 >> 1);
        System.out.println(c);
    }
}
