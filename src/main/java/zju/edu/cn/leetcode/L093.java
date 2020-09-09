package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/9 15:10
 * @strategy 回溯法
 * >> 约束规则：已经放置了一个点，下一个点只有 3 种可能：1/2/3
 * >> 使用 LinkedList 来对各个整数进行存储，
 *    可以用 String.join 来连接链表的各个部分，成为一个整体
 *    也可以用 removeLast 来方便删除最后一个元素
 *    使用 ArrayList 来保存最后的结果
 */
public class L093 {
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> output = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }

    private boolean valid(String segment) {
        int m = segment.length();
        if (m > 3) {
            return false;
        } else {
            return segment.charAt(0) == '0' ? m == 1 : Integer.parseInt(segment) <= 255;
        }
    }

    private void update(int cur) {
        String segment = s.substring(cur + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    private void backtrack(int pre, int dots) {
        //约束规则
        int max = Math.min(n - 1, pre +  4);
        for (int cur = pre + 1; cur < max; cur++) {
            String segment = s.substring(pre + 1, cur + 1);
            if (valid(segment)) {
                segments.add(segment);
                if (dots - 1 == 0) {
                    update(cur);
                } else {
                    //只传递值下去，没有给 dots--
                    backtrack(cur, dots - 1);
                }
                segments.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(Integer.valueOf(str));
    }
}
