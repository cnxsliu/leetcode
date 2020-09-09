package zju.edu.cn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/4 18:34
 * @strategy 滑动窗口
 */
public class L076 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        //目标字符串的字典
        Map<Character, Integer> dicT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dicT.getOrDefault(t.charAt(i), 0);
            dicT.put(t.charAt(i), count + 1);
        }
        //字典中包含几个元素
        int required = dicT.size();
        int l = 0;
        int r = 0;
        //现在已经包含的字典中的元素
        int formed = 0;
        //现在窗口中的元素及其个数
        Map<Character, Integer> windowCounts = new HashMap<>();
        //最短子串长度，left，right
        int[] ans = {-1, 0, 0};
        //外循环移动右指针 r
        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);
            if (dicT.containsKey(c) && windowCounts.get(c).intValue() == dicT.get(c).intValue()) {
                formed++;
            }
            //内循环移动左指针 l
            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dicT.containsKey(c) && windowCounts.get(c) < dicT.get(c)) {
                    formed --;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
