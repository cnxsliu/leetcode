package zju.edu.cn.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/17 19:49
 * @strategy 动态规划
 * >> 对于 s.substring() 这个过程，比较消耗时间
 */
public class L139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // 注意 break，可以节省时间
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        if (wordDict.contains(s)) {
            return true;
        }
        LinkedList<String> list = new LinkedList<>();
        list.addLast(s);
        while (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String temp = list.poll();
                for (int j = 0; j < temp.length(); j++) {
                    if (wordDict.contains(temp.substring(0,j + 1))) {
                        if (wordDict.contains(temp.substring(j + 1))) {
                            return true;
                        } else {
                            list.addLast(temp.substring(j + 1));
                        }
                    }
                }
            }
        }
        return false;
    }
}
