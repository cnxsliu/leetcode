package zju.edu.cn.review;

/**
 * @author cnxsliu
 * @date 2020/6/29 17:01
 * 迭代
 * 注意输入校验
 */
public class L014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (String str : strs) {
            if (str == null || str.length() == 0) {
                return "";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (true) {
            if (index >= strs[0].length()) {
                return stringBuilder.toString();
            }
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != c) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(c);
            index++;
        }
    }
}
