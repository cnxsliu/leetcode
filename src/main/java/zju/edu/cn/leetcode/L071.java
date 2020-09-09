package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/3 19:34
 * @strategy 辅助栈
 * >> Stack 可以通过 get(i) 从底向上取出对应位置的元素
 */
public class L071 {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i= 0; i < s.length; i++) {
            if (!stack.isEmpty() && "..".equals(s[i])) {
                stack.pop();
            } else if (!"..".equals(s[i]) && !"".equals(s[i]) && !".".equals(s[i])) {
                stack.push(s[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/").append(stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L071 L = new L071();
        String str = "/home/";
        String str2 = "/a/../../b/../c//.//";
        String str3 = "/home//foo/";
        String str4 = "/a/./b/../../c/";
//        System.out.println(L.simplifyPath(str));
        System.out.println(L.simplifyPath(str2));
        System.out.println(L.simplifyPath(str3));
        System.out.println(L.simplifyPath(str4));

    }
}
