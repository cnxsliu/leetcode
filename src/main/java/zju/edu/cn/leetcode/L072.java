package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/4 15:44
 * @strategy 动态规划
 * >> 数组在声明之后会默认初始值
 * >> 需要对二维数组 dp[][] 的第一行和第一列赋初始值，属于直接增加元素和删除元素的操作
 */
public class L072 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int [][] dp = new int[n1 + 1][n2 + 1];
        //初始化
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= n1; i++) {
            for ( int j = 1; j <= n2; j++) {
                //word1的第 i 个字符和word2的第 j 个字符相同
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        L072 L = new L072();
        System.out.println();
    }
}
