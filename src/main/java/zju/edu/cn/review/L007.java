package zju.edu.cn.review;

/**
 * @author cnxsliu
 * @date 2020/6/23 15:55
 * 大数问题
 * 两个策略：1、转化为 long 型变量；2、使用 BigDecimal
 */
public class L007 {
    public int reverse(int x) {
        long X = x;
        boolean minus = x < 0;
        long res = 0;
        X = Math.abs(X);
        while (X != 0) {
            res = res * 10 + X % 10;
            X = X / 10;
        }
        if (minus) {
            if (res * (-1) < Integer.MIN_VALUE) {
                return 0;
            } else {
                return (int) (-1 * res);
            }
        } else {
            if (res > Integer.MAX_VALUE) {
                return 0;
            } else {
                return (int) res;
            }
        }
    }
}
