package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/17 17:11
 * @strategy 位运算
 */
public class L137 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ~twos & (ones ^ num);
            twos = ~ones & (twos ^ num);
        }
        return ones;
    }
}
