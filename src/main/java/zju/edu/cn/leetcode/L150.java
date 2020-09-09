package zju.edu.cn.leetcode;

import java.util.Stack;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/21 23:03
 * @strategy 栈 Stack
 * >> 使用一个栈来保存符号，使用一个栈来保存数据
 */
public class L150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> chs = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])) {
                int right = nums.pop();
                int left = nums.pop();
                if ("+".equals(tokens[i])) {
                    nums.add(left + right);
                } else if ("-".equals(tokens[i])) {
                    nums.add(left - right);
                } else if ("*".equals(tokens[i])) {
                    nums.add(left * right);
                } else {
                    nums.add(left / right);
                }
            } else {
                nums.add(Integer.parseInt(tokens[i]));
            }
        }
        return nums.pop();
    }
}
