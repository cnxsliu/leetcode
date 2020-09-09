package zju.edu.cn.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @date 2020/6/23 15:36
 * 迭代
 * 使用 List 和 StringBuilder 来对每一行的结果进行记录
 * 使用一个 boolean 类型的标记位来控制迭代的方向，使用一个 int 类型变量来控制迭代的位置
 */
public class L006 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
