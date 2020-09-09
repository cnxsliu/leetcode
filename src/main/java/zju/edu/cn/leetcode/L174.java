package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 17:31
 * @strategy 动态规划
 * >> 从右下到左上进行分析
 */
public class L174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = Math.max(0, -dungeon[row - 1][col - 1]);
        for (int i = row - 2; i >= 0; i--) {
            int needMin = dp[i + 1][col - 1] - dungeon[i][col - 1];
            dp[i][col - 1] = Math.max(0, needMin);
        }
        for (int i = col - 2; i >= 0; i--) {
            int needMin = dp[row - 1][i + 1] - dungeon[row - 1][i];
            dp[row - 1][i] = Math.max(0, needMin);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, min);
            }
        }
        return dp[0][0] + 1;
    }

    public static void main(String[] args) {
        L174 L = new L174();
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[][] arr2 = {{1,-4,5,-99},{2,-2,-2,-1}};
        System.out.println(L.calculateMinimumHP(arr2));
    }
}
