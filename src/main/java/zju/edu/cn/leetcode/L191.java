package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/27 15:20
 * @strategy 逻辑运算
 * >> 必须要用无符号右移 >>>，不能使用 >>
 */
public class L191 {
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            num += (n & 1);
            n = n >>> 1;
        }
        return num;
    }
}
