package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/17 16:00
 * @strategy 一次迭代
 * >> 使用 totalTank 来计算总的剩余的油量
 * >> 使用 curTank 来计算当前油量
 */
public class L134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int totalTank = 0;
        int curTank = 0;
        int startStation = 0;
        for (int i = 0; i < len; i++) {
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            if (curTank < 0) {
                startStation = i + 1;
                curTank = 0;
            }
        }
        return totalTank >= 0 ? startStation : -1;
    }
}
