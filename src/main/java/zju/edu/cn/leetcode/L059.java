package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/30 18:00
 * @strategy 模拟法
 * >> 尤其要注意 matrix[][] 中横纵坐标位置，很容易出错
 */
public class L059 {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1;
        int tar = n * n;
        int[][] matrix = new int[n][n];
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                matrix[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                matrix[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                matrix[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }
        return matrix;
    }
}
