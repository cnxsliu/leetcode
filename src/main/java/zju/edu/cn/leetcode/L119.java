package zju.edu.cn.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/13 16:34
 * @strategy
 */
public class L119 {
    LinkedList<Integer> res = new LinkedList<>();
    public List<Integer> getRow(int rowIndex) {
        res.addLast(1);
        if (rowIndex == 0) {
            return res;
        }
        res.addLast(1);
        if (rowIndex == 1) {
            return res;
        }
        while (rowIndex > 1) {
            int len = res.size();
            for (int i = 0; i < len - 1; i++) {
                int left = res.poll();
                int right = res.peek();
                res.addLast(left + right);
            }
            res.addLast(1);
            rowIndex--;
        }
        return res;
    }
}
