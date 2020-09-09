package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/23 16:51
 * @strategy 记忆迭代
 * >> 用一个 tempMax 来保存（正）最大值，用一个 tempMin 来保存(负)最小值
 */
public class L152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE, tempMax = 1, tempMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = tempMax;
                tempMax = tempMin;
                tempMin = temp;
            }
            tempMax = Math.max(tempMax * nums[i], nums[i]);
            tempMin = Math.min(tempMin * nums[i], nums[i]);
            max = Math.max(max, tempMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        L152 L = new L152();
        System.out.println(L.maxProduct(arr));
    }
}
