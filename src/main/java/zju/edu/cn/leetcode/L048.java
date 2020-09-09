package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/26 18:36
 * @strategy 数组反转：转置+每行反转
 */
public class L048 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //转置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //每行反转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j -1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
