package zju.edu.cn.leetcode;

import java.util.HashSet;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/17 16:58
 * @strategy 位运算：异或
 * >> 两个相同的数字异或结果是 0
 */
public class L136 {
    // 效率极高
    public int singleNumber(int[] nums) {
        int num = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                num ^= nums[i];
            }
        }
        return num;
    }

    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        long num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                num -= nums[i];
            }
            else {
                set.add(nums[i]);
                num += nums[i];
            }
        }
        return (int)num;
    }


}
