package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/17 16:25
 * @strategy
 */
public class L135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left2right = new int[len];
        int[] right2left = new int[len];
        // Arrays.fill(arr, 1) 的效率比下面迭代的方法慢
        for (int i = 0; i < len; i++) {
            left2right[i] = 1;
            right2left[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
            if (ratings[len - i - 1] > ratings[len - i]) {
                right2left[len - i - 1] = right2left[len - i] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }
}
