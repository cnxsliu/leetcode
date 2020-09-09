package zju.edu.cn.leetcode;

import java.math.BigDecimal;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/2 15:36
 * @strategy 数学公式：组合公式；动态规划更好一些
 * >> 使用 BigDecimal 来防止数值超出范围
 * >> DigDecimal 的操作有：add():+, subtract():-, multiply():/, divide():*
 */
public class L062 {

    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        return (factorial(m + n - 2).divide((factorial(m - 1).multiply(factorial(n - 1))))).intValue();
    }

    private BigDecimal factorial(int m) {
        BigDecimal res = new BigDecimal(1);
        BigDecimal M = new BigDecimal(m);
        while (m != 1) {
            res = res.multiply(M);
            M = M.subtract(new BigDecimal(1));
            m--;
        }
        return res;
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i< m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j- 1];
            }
        }
        return dp[m-1][n-1];
    }



    public static void main(String[] args) {
        L062 L = new L062();
        System.out.println(L.uniquePaths2(3,2));

    }
}
