package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/2 16:48
 * @strategy 动态规划
 * >> 在初始化的时候，如果 dp[][] 对应的位置如果有障碍，则该位置及后面都要赋值为 0
 * >> 在动态规划遍历的过程中，对前一位置的是否有障碍进行判断，如果存在障碍则加 0
 */
public class L063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                for (int j = i; j < m; j++) {
                    dp[i][0] = 0;
                }
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                for (int j = i; j < n; j++) {
                    dp[0][j] = 0;
                }
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    //三目运算符要注意 + ，不同模块之间最好用括号隔开，否则容易引起错误
                    dp[i][j] = (obstacleGrid[i-1][j] == 1 ? 0 : dp[i-1][j]) +
                            (obstacleGrid[i][j-1] == 1 ? 0 : dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        L063 L = new L063();
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(L.uniquePathsWithObstacles(arr));
    }
}
