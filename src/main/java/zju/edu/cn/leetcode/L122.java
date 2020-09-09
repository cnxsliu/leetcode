package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/13 19:18
 * @strategy
 */
public class L122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int low = prices[0];
        int high = prices[0];
        int sum = 0;
        int index = 1;
        while (index < prices.length) {
            // 上升时，保存高位
            if (prices[index] > prices[index - 1]) {
                high = prices[index];
            } else {
                // 下降时，将 高位 - 低位 的结果保存，将高位和低位都更新为下降位置的值
                sum += high - low;
                low = prices[index];
                high = prices[index];
            }
            index++;
        }
        // 最后还要在加上 high - low，防止最后是上升的情况
        return sum + high - low;
    }
}
