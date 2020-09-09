package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/13 19:33
 * @strategy 动态规划
 * >> 有点难
 */
public class L123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // dp[天数][是否持有股票][卖出次数]
        int[][][] dp = new int[len][2][3];
        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];
        // 将 Integer>MIN_VALUE 的值右移一位，防止计算过程中向左溢出，变成正数
        dp[0][0][1] = Integer.MIN_VALUE >> 1;
        dp[0][0][2] = Integer.MIN_VALUE >> 1;
        dp[0][1][1] = Integer.MIN_VALUE >> 1;
        dp[0][1][2] = Integer.MIN_VALUE >> 1;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
        }
        return Math.max(dp[len - 1][0][1], Math.max(dp[prices.length - 1][0][0], dp[prices.length - 1][0][2]));
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
