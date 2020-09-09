package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/2 19:43
 * @strategy 递归
 * >> 如果递归函数有返回值，那么条件终止时一定要把值返回，否则会使程序结果出错
 */
public class L066 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length <= 0) {
            return null;
        }
        return add(digits, digits.length-1);
    }

    private int[] add(int[] digits,int idx) {
        if (digits[idx] == 9) {
            digits[idx] = 0;
            if (idx == 0) {
                int[] digits2 = new int[digits.length + 1];
                digits2[0] = 1;
                for (int i = 1; i < digits2.length; i++) {
                    digits2[i] = digits[i-1];
                }
                return digits2;
            }
            return add(digits, idx-1);
        }
        digits[idx] = digits[idx] + 1;
        return digits;
    }

    public static void main(String[] args) {
        L066 L = new L066();
        int[] arr = {9,9};
        System.out.println(L.plusOne(arr));
    }
}
