package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/9 17:17
 * @strategy 动态规划
 * >> 对于字符串变化的问题，可以优先考虑二维数组的动态规划
 *    如果使用回溯法，很容易出现超时
 * >> 动态规划的数组建立的长度要比字符串长度大 1
 * >> dp[][] 初始化时，先初始化 d[0][0] ，再初始化 dp[0][j], dp[i][0]
 *    注意一定要初始化到最后一位
 */
public class L097 {
    public boolean isInterleave2(String s1, String s2, String s3) {
        int idx1 = 0, idx2 = 0;
        return helper(s1,s2,s3,0,0,0);
    }

    private boolean helper(String s1, String s2, String s3, int idx1, int idx2, int idx3) {
        if (idx3 == s3.length()) {
            if (idx1 == s1.length() && idx2 == s2.length()) {
                return true;
            } else {
                return false;
            }
        }
        boolean flag1 = false;
        boolean flag2 = false;
        if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3)) {
            flag1 = helper(s1,s2,s3,idx1 + 1, idx2, idx3+ 1);
        }
        if (idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx3)) {
            flag2 = helper(s1,s2,s3,idx1,idx2 +1, idx3 + 1);
        }
        return flag1 || flag2;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j -1) ||
                dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[s1.length()][s2.length()];
    }


    public static void main(String[] args) {
        L097 L = new L097();
        String str1 = "accbaabaaabbcbaacbababacaababbcbabaababcaabbbbbcacbaa";
        String str2 = "cabaabcbabcbaaaacababccbbccaaabaacbbaaabccacabaaccbbcbcb";
        String str3 = "accbcaaabbaabaaabbcbcbabacbacbababaacaaaaacbabaabbcbccbbabbccaaaaabaabcabbcaabaaabbcbcbbbcacabaaacccbbcbbaacb";
        System.out.println(L.isInterleave(str1, str2,str3));
    }
}
