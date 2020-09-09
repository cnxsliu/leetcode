package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 16:35
 * @strategy 5 的个数
 * >> 每隔 5 个数，出现一个 5，每隔 25 个数，出现 2 个 5，
 *    每隔 125 个数，出现 3 个 5... 以此类推。
 */
public class L172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
