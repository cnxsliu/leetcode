package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/28 15:25
 * @strategy 逻辑运算：>>>，<<
 */
public class L201 {
    public int rangeBitwiseAnd(int m, int n) {
        int zeros = 0;
        while (m < n) {
            zeros++;
            m = m >>> 1;
            n = n >>> 1;
        }
        return m << zeros;
    }
}
