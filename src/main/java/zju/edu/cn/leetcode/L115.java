package zju.edu.cn.leetcode;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/12 21:06
 * @strategy 动态规划
 * >> 创建一个二维数组，分别对应 T 和 S 的维度，长度分别比 T 和 S 的长度大一
 * >> 当 t.charAt(i - 1) == s.charAt(j - 1)，可以按照两个路线来计算到 T 的第 i 位和 S 的第 j 位的满足条件的结果个数：
 *    1、按照这次相等的元素来计算，dp[i - 1][j- 1]
 *    2、不按照这次相等的元素来计算，则需要让 T 的第 i 位和 S 的前 j 位的某个元素来匹配，dp[i - 1][j- 1]
 *    注意：dp[i][j]必须找到 T 的第 i 位和 S 中的某一位匹配，也是按照这个角度来进行分类讨论的
 * >> t.charAt(i - 1) ！= s.charAt(j - 1)，也是让 T 的第 i 位和 S 的前 j 位的某个元素来匹配，dp[i - 1][j- 1]
 */
public class L115 {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        int[][] dp = new int[t.length()+1][s.length() + 1];
        for (int j = 0; j < s.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j- 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        L115 L = new L115();
        System.out.println(L.numDistinct("rabbbit", "rabbit"));
    }
}
