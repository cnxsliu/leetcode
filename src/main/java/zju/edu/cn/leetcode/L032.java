package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/21 14:02
 * @strategy 动态规划
 */
public class L032 {
    public static void main(String[] args) {
        String str = "(((()))()()()";
        System.out.println(longestValidParentheses(str));
    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            //当第i个字符是')'的时候，才进行动态处理，否则就不需要做处理
            if (s.charAt(i) == ')') {
                //根据i - 1个字符的情况，分为两种情况来讨论
                if (s.charAt(i - 1) == '(') {
                    dp[i] = ((i >= 2) ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
