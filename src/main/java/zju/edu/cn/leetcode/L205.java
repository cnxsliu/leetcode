package zju.edu.cn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/28 16:25
 * @strategy 第三方数组
 * >> 可以使用哈希表，但是时间效率低一些
 */
public class L205 {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
    }

    private String isIsomorphicHelper(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当前字母第一次出现,赋值
            if (map[c] == 0) {
                map[c] = i + 1;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s ==null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) {
                    return false;
                }
            } else if (set.contains(ch2)) {
                return false;
            } else {
                map.put(ch1, ch2);
                set.add(ch2);
            }
        }
        return true;
    }
}
