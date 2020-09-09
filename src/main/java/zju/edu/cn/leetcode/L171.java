package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 16:31
 * @strategy
 */
public class L171 {
    public int titleToNumber(String s) {
        long res = 0L;
        for (int i = 0; i < s.length(); i++) {
            res *= 26;
            res += s.charAt(i) - 'A' + 1;
        }
        return (int)res;
    }
}
