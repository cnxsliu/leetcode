package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/4 16:29
 * @strategy 迭代
 * >> 注意行标记和列标记和原始数组的对应关系
 */
public class L073 {
    public void setZeroes(int[][] matrix) {
        boolean[] col = new boolean [matrix[0].length];
        boolean[] row = new boolean [matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (col[j] || row[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
