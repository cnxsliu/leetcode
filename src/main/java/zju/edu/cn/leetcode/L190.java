package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/26 17:56
 * @strategy
 */
public class L190 {
    public int reverseBits(int n) {
        int res = 0;
        int i = 32;
        while (i > 0) {
            res += (n & 1) << (i - 1);
            n = n >> 1;
            i--;
        }
        return res;
    }
}
