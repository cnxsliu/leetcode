package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/7 19:42
 * @strategy 动态规划
 * >> 可以使用两个计数器叠加的方式来实现
 */
public class L091 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        char[] ch = s.toCharArray();
        int[] dp = new int[ch.length];
        dp[0] = 1;
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == '0') {
                if (ch[i - 1] == '1' || ch[i - 1] == '2') {
                    if (i == 1) {
                        dp[i] = 1;
                    } else {
                        dp[i] = dp[i - 2];
                    }
                }else {
                    return 0;
                }
            } else if (ch[i - 1] == '1' || (ch[i - 1] == '2') && (ch[i] >= '1' && ch[i] <= '6')) {
                if (i == 1) {
                    dp[i] = 1 + 1;
                }else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[ch.length - 1];
    }

    int numDecodings2(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        char[] ch = s.toCharArray();
        if (ch[0] == '0') {
            return 0;
        }
        //dp[-1] = dp[0] = 1
        int pre = 1, curr = 1;
        for (int i = 1; i < ch.length; i++) {
            int tmp = curr;
            if (ch[i] == '0') {
                if (ch[i - 1] == '1' || ch[i - 1] == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            } else if (ch[i - 1] == '1' || (ch[i - 1] == '2' && ch[i] >= '1' && ch[i] <= '6')) {
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;
    }

    public static void main(String[] args) {
        L091 L = new L091();
        System.out.println(L.numDecodings("0"));
    }
}
