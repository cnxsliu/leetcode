package zju.edu.cn.leetcode;

import java.util.*;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/26 19:02
 * @strategy 字符串操作：排序数组+分类
 * >> 使用 HashMap 来存储, HashMap<String, List<String>>
 * >> 可以将 HashMap.values() 直接转成 ArrayList
 */
public class L049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> res  = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            if (!res.containsKey(String.valueOf(ch))) {
                res.put(String.valueOf(ch), new ArrayList<>());
            }
            res.get(String.valueOf(ch)).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
