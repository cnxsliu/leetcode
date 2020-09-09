package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/26 19:44
 * @strategy 递归：快速幂
 * >> 将 m ^ n 的平方根等于 (m ^ n/2 ) 或者 (m ^ n/2) * (m ^ n/2)的平方根
 */
public class L050 {
    public double myPow(double x, int n) {
        // long N = n;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    public double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        int N = n / 2;
        double res = fastPow(x, N);
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
    }
}
