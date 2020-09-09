package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/25 15:48
 * @strategy 竖式法的优化
 */
public class L043 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                //注意是用 res[i+j+1] 来加上 n1*n2
                int sum = res[i + j + 1] + n1 * n2;
                //注意是 =
                res[i + j + 1] =  sum % 10;
                //注意是 +=
                res[i + j] +=  sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            //防止n1*n2是个位数，十位数为0
            if (i == 0 && res[i] == 0) {
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
