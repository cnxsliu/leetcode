package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/2 18:26
 * @strategy 动态规划
 * >> 动态规划遍历的时候，要用 dp[][]之前的值和 grid[][] 现在的值进行累加
 * >> 需要给 dp[0][0] 赋值
 */
public class L064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        L064 L = new L064();
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(L.minPathSum(arr));
    }
}
