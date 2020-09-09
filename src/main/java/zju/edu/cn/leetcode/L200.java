package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/27 17:17
 * @strategy 记忆递归
 */
public class L200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    num++;
                    trace(grid, visited, row, col, i, j);
                }
            }
        }
        return num;
    }

    private void trace(char[][] grid, boolean[][] visited, int row, int col, int i, int j) {
        visited[i][j] = true;
        if (i + 1 < row && !visited[i + 1][j] && (grid[i + 1][j] == '1')) {
            trace(grid, visited, row, col, i + 1, j);
        }
        if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == '1') {
            trace(grid, visited, row, col, i - 1, j);
        }
        if (j + 1 < col && !visited[i][j + 1] && grid[i][j + 1] == '1') {
            trace(grid, visited, row, col, i, j + 1);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == '1') {
            trace(grid, visited, row, col, i, j - 1);
        }
    }

    public static void main(String[] args) {
        char[][] gird = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        L200 L = new L200();
        System.out.println(L.numIslands(gird));
    }
}
