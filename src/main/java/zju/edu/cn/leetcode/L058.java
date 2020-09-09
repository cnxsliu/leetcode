package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/30 17:34
 * @strategy 迭代
 */
public class L058 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (isChar(s.charAt(i))){
                int count = 0;
                while (i >= 0 && isChar(s.charAt(i--))) {
                    count++;
                }
                return count;
            }
        }
        return 0;
    }

    public boolean isChar(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println('A'-'a');
        System.out.println('A'-'B');
        System.out.println('Z'-'a');
    }
}
