package zju.edu.cn.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cnxsliu
 * @date 2020/6/20 17:46
 * 滑动窗口 + 哈希表
 * 1、关键在于如何移动左边的边界，
 * left = Math.max(left, map.get(s.charAt(right)) + 1);
 * 2、使用 HashMap 来存储已经出现的字符
 */
public class L003 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        if (s == null || s.length() == 0) {
            return maxLen;
        }
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        L003 L = new L003();
        System.out.println(L.lengthOfLongestSubstring("abba"));
    }
}
