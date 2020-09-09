package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/25 18:17
 * @strategy 动态规划
 * >> 在 s 为空的情况下，需要对 p 的 * 进行简化
 */
public class L044 {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        //f[i][j]表示 s 的第 i 个字符和 p 的第 j 个字符 及之前的部分是否匹配
        boolean[][] f = new boolean[m + 1][n + 1];
        //表示空的 s 和空的 p 是匹配的
        f[0][0] = true;
        //在空的 s 时，对 p 进行简化
        for (int i = 1; i <= n; i++) {
            f[0][i] = f[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    f[i][j] = f[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i - 1][j] || f[i][j - 1];
                }
            }
        }
        return f[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("acdcb", "a*c?b"));
        System.out.println(isMatch("adceb", "*a*b"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("", "*"));
    }
}
