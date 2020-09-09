package zju.edu.cn.leetcode;

import java.util.LinkedList;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/16 18:47
 * @strategy 动态规划
 * >> 使用回溯法逻辑应该是没问题的，但是时间复杂度过高
 * >> 字符串的动态规划，肯定是从左往右遍历，注意要进行初始化
 */
public class L132 {
    public int minCut(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        int[] dpNew = new int[len];
        for (int i = 0; i < len ; i++) {
            dpNew[i] = i;
        }
        for (int i = 0; i < len; i++) {
            if (dp[0][i]) {
                dpNew[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j + 1][i]) {
                    dpNew[i] = Math.min(dpNew[i], dpNew[j] + 1);
                }
            }
        }
        return dpNew[len - 1];
    }



    public int minCut2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        if (dp[0][len - 1]) {
            return 0;
        }
        LinkedList<Integer> indexList = new LinkedList<>();
        indexList.addLast(0);
        indexList.addLast(len - 1);
        int cutNum = 0;
        while (indexList.size() > 0 ) {
            int size = indexList.size() >> 1;
            for (int i = 0; i < size; i++) {
                int left = indexList.poll();
                int right = indexList.poll();
                for (int j = left; j <= right; j++) {
                    if (dp[left][j]) {
                        if (j == len - 1 || dp[j + 1][right]) {
                            return ++cutNum;
                        }
                        indexList.addLast(j + 1);
                        indexList.addLast(right);
                    }
                }
            }
            cutNum++;
        }
        return len - 1;
    }
}
