package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/16 15:47
 * @strategy DFS
 * >> 非常典型，值得学习
 * >> dfs 的方向为前后左右
 */
public class L130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // 第一次遍历查找和边界 O 相连的 O，并将其转化为 #
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start from edge
                boolean isEdge = 0 == i || m - 1 == i || 0 == j || n - 1 == j;
                if (isEdge && board[i][j] == 'O') {
                   dfs(board, m, n, i,  j);
                }
            }
        }
        // 第二次遍历，将 O 替换为 X，将 # 替换为 O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        dfs(board, m, n, i + 1, j);
        dfs(board, m, n, i - 1, j);
        dfs(board, m, n, i, j + 1);
        dfs(board, m, n, i, j - 1);
    }

    public static void main(String[] args) {
        L130 L = new L130();
        char[][] chs = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] chs2 = {{'O','X','O'},{'X','O','X'},{'O','X','O'}};
        L.solve(chs2);
    }
}
