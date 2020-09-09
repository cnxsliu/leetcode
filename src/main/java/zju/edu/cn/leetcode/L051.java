package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/28 17:40
 * @strategy 回溯法
 * >> 只需要按列循环即可
 * >> 对于所有的主对角线有 行号 + 列号 = 常数
 * >> 对于所有的次对角线有 行号 - 列号 = 常数
 */
public class L051 {
    int[] rows;
    int[] hills;
    int[] dales;
    int n;
    List<List<String>> output = new ArrayList();
    int[] queens;

    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public void placeQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        hills[row - col + 2 * n] = 1;
        dales[row + col] = 1;
    }

    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public void addSolution(){
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                sb.append(".");
            }
            sb.append("Q");
            for (int j = 0; j < n - col -1; j++) {
                sb.append(".");
            }
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public void backTrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)){
                placeQueen(row, col);
                if (row + 1 == n) {
                    addSolution();
                }
                else {
                    backTrack(row + 1);
                }
                removeQueen(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];
        backTrack(0);
        return output;
    }
}
