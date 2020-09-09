package zju.edu.cn.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/13 16:21
 * @strategy BFS
 */
public class L118 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        res.add(new LinkedList<Integer>(list));
        if (numRows == 1) {
            return res;
        }
        list.addLast(1);
        res.add(new LinkedList<>(list));
        if (numRows == 2) {
            return res;
        }
        while (numRows  > 2) {
            int len = list.size();
            for (int i = 0; i < len - 1; i++) {
                int left = list.poll();
                int right = list.peek();
                list.addLast(left + right);
            }
            list.addLast(1);
            res.add(new LinkedList<>(list));
            numRows--;
        }
        return res;
    }
}
