package zju.edu.cn.leetcode;

import java.util.*;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/18 20:28
 * @strategy
 */
public class L140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    public boolean isWordBreak(String s, List<String> wordDict) {
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

    public static void main(String[] args) {
        L140 L = new L140();
        String s = "catsanddog";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> res = L.wordBreak(s, wordDict);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
