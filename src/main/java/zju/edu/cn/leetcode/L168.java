package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 16:16
 * @strategy 进制转换：取余 + 取商
 * >> 由于进制转换（10 进制到 26 进制）是 0 - 25，而实际是 1 - 26，
 *    对于边界 26 需要单独判断处理一下
 * >> 数据结构：StringBuilder
 * >> 余数（%）就是进位，然后求商，对商迭代
 */
public class L168 {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            int c = n % 26;
            if (c == 0) {
                c = 26;
                // 防止前一位为 26是进位
                n = n - 1;
            }
            res.insert(0, (char)('A' + c - 1));
            n = n / 26;
        }
        return res.toString();
    }
}
