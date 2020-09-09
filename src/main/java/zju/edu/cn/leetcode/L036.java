package zju.edu.cn.leetcode;

import sun.rmi.server.InactiveGroupException;

import java.util.HashMap;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/22 15:00
 * @strategy 迭代
 * >> 迭代过程中对行、列、子数独分别维护一个存储结构：数组+哈希表
 * >> 子数独中元素横、纵坐标到数组索引的转换是关键，index = (row/3)*3+columns/3
 * >> 字符和数字的强制转换
 */
public class L036 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n,0) + 1);
                    if (rows[i].get(n) > 0 || columns[j].get(n) > 0 || boxes[box_index].get(n) > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
