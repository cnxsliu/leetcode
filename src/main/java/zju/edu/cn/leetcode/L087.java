package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/7 15:54
 * @strategy 区间dp，区间动态规划
 * >> dp[i][j][k]：子串1从第 i 个位置后的 k 个字符是否和
 *    子串2从第 j 个位置后的 k 个字符
 *    相等 或者 可以通过变换得到
 */
public class L087 {
    public boolean isScramble(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int n = s1.length();
        int m = s2.length();
        if (n != m) {
            return false;
        }
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = chs1[i] == chs2[j];
            }
        }
        // 枚举区间从 2 到 n
        for (int len = 2; len <= n; len++) {
            //子串1的起始位置为 0 到 n - len
            for (int i = 0; i<= n -len; i++) {
                // 子串2的起始位置为 0 到 n - len
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k <= len - 1; k++) {
                        // S1 -> T1, S2 -> T2
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        // S1 -> T2, S2 -> T1
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
