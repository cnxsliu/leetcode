package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/14 14:50
 * @strategy 双指针
 */
public class L125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));
            if (!isChar(l)) {
                left++;
                continue;
            }
            if (!isChar(r)) {
                right--;
                continue;
            }
            if (isChar(l) && isChar(r) && l == r) {
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean isChar(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
            return true;
        }
        return false;
    }
}
