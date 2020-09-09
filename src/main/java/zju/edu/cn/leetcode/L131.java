package zju.edu.cn.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/16 17:15
 * @strategy 回溯法 + 动态规划
 * >> 判断是否是回文子串可以使用动态规划，而且不需要初始化
 */
public class L131 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        // 使用动态规划判断字符串从 i 到 j 是否是回文子串
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        backtrack(s, 0, dp, new ArrayDeque<>());
        return res;
    }

    private void backtrack(String s, int start, boolean[][] dp, Deque<String> path) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                path.addLast(s.substring(start, i + 1));
                backtrack(s, i + 1, dp, path);
                path.removeLast();
            }
        }
    }
}
