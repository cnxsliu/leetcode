package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/22 17:46
 * @strategy 迭代
 * >> 起始几种情况可以直接输出
 * >> 通过for循环进行字符串遍历的时候，要在 i 到达 len 之前将结果保存，否则会丢失
 */
public class L038 {
    public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        } else if (n == 1) {
            return "1";
        } else if(n == 2) {
            return "11";
        }
        String num = "11";

        while (n > 2) {
            int len = num.length();
            char cur = num.charAt(0);
            int count = 1;
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < len; i++) {
                char ch = num.charAt(i);
                if (cur == ch) {
                    count++;
                } else {
                    sb.append(count).append(cur);
                    cur = ch;
                    count = 1;
                }
                if (i == len -1) {
                    sb.append(count).append(cur);
                    num = sb.toString();
                }
            }
            n--;
        }
        return num;
    }

    public static void main(String[] args) {
          System.out.println(countAndSay(5));
    }
}
