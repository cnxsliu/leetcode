package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/26 15:53
 * @strategy 哈希表
 * >> 用一个 HashSet 来保存已有的 String
 */
public class L187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < s.length() - 10 + 1; i++) {
            String temp = s.substring(i, i + 10);
            if (seen.contains(temp)) {
                res.add(temp);
            } else {
                seen.add(temp);
            }
        }
        return new ArrayList<>(res);
    }
}
