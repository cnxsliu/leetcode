package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/28 20:53
 * @strategy 直观法； 方法二：模拟
 * >> 每次添加元素之后，判断下一步的方向
 * >> 使用一个flag数组对已经走过的地方进行标记
 * >> 参数校验，如果输入为空，则返回空的list，但是list需要分配内存空间，否则等于null
 * >> x 代表列数， y 代表行数，因此数组形式为 matrix[y][x]
 */
public class L054 {
    List<Integer> list;
    boolean[][] flag;
    public List<Integer> spiralOrder(int[][] matrix) {
        list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        flag = new boolean[matrix.length][matrix[0].length];
        for ( int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                flag[i][j] = false;
            }
        }
        right(matrix, 0, 0);
        return list;
    }

    private void right(int[][] matrix, int x, int y) {
        list.add(matrix[y][x]);
        flag[y][x] = true;
        if (x + 1 == matrix[0].length || flag[y][x + 1]) {
            if ( y + 1 == matrix.length || flag[y + 1][x]) {
                return;
            }
            down(matrix, x, y + 1);
            return;
        }
        right(matrix, x + 1, y);
    }

    private void down(int[][] matrix, int x , int y) {
        list.add(matrix[y][x]);
        flag[y][x] = true;
        if (y + 1 == matrix.length || flag[y +1][x]) {
            if (x == 0 || flag[y][x - 1]) {
                return;
            }
            left(matrix, x - 1, y );
            return;
        }
        down(matrix, x, y +1);
    }

    private void left(int[][] matrix, int x, int y) {
        list.add(matrix[y][x]);
        flag[y][x] = true;
        if (x == 0 || flag[y][x - 1]) {
            if (y == 0 || flag[y - 1][x]) {
                return;
            }
            up(matrix, x, y - 1);
            return;
        }
        left(matrix, x - 1, y);
    }

    private void up(int[][] matrix, int x, int y) {
        list.add(matrix[y][x]);
        flag[y][x] = true;
        if (y == 0 || flag[y - 1][x]) {
            if (x + 1 == matrix[0].length || flag[y][x + 1]) {
                return;
            }
            right(matrix, x + 1, y);
            return;
        }
        up(matrix, x, y - 1);
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
        L054 L = new L054();
//        System.out.println(L.spiralOrder(arr2));

        System.out.println(L.spiralOrder(arr));
    }
}
