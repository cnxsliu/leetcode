package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/5 16:13
 * @strategy 回溯法
 */
public class L079 {
    public boolean exist(char[][] board, String word) {
        boolean[][] flag ;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                flag = new boolean[board.length][board[0].length];
                if (search(board, flag, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] flag, String word, int idx, int row, int col) {
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || flag[row][col]) {
            return false;
        }

        if (word.charAt(idx) == board[row][col]) {
            flag[row][col] = true;
            if (idx == word.length() - 1) {
                return true;
            }
            idx++;
            boolean temp =
                    search(board, flag, word, idx, row + 1, col) ||
                    search(board, flag, word, idx, row, col + 1) ||
                    search(board, flag, word, idx, row - 1, col) ||
                    search(board, flag, word, idx, row, col - 1) ;
            if (temp) {
                return true;
            } else {
                flag[row][col]  = false;
                idx--;
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L079 L = new L079();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCA";
        System.out.println(L.exist(board, word3));

    }
}
