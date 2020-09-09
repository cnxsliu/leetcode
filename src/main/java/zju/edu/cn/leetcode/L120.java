package zju.edu.cn.leetcode;

import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/13 16:42
 * @strategy 动态规划
 * >> 使用 DFS 超时，但是逻辑应该没问题
 */
public class L120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < col; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][triangle.get(i).size() - 1] = dp[i - 1][triangle.get(i - 1).size() - 1] + triangle.get(i).get(triangle.get(i).size() - 1);
        }

        for (int i = 1; i < col; i++) {
            for (int j = 1; j < triangle.get(i).size() - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(row - 1).size(); i++) {
            min = Math.min(min, dp[row - 1][i]);
        }
        return min;
    }

    int min = Integer.MAX_VALUE;
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        dfs(triangle, 0, 0, triangle.get(0).get(0));
        return min;
    }

    private void dfs(List<List<Integer>> triangle, int level, int idx, int sum) {
        if (level == triangle.size() - 1) {
            min = Math.min(sum, min);
            return;
        }
        for (int i = 0; i < triangle.get(level).size(); i++) {
            dfs(triangle, level + 1, idx, sum + triangle.get(level + 1).get(idx));
            dfs(triangle, level + 1, idx + 1, sum + triangle.get(level + 1).get(idx + 1));
        }
    }
}
