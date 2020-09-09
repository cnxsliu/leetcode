package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/6 20:58
 * @strategy 分治法
 * >> 以每个区间的最矮的柱子作为分界点，分别三部分：
 *    最矮柱子左边的最大矩形，最矮柱子右边的最大矩形，包含最矮柱子的最大矩形
 *    然后取出上面三个中的最大值，并不断在左、右递归
 */
public class L084 {
    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public int calculateArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int minindex = start;
        for (int i = start; i <= end; i++) {
            if (heights[minindex] > heights[i]) {
                minindex = i;
            }
        }
        return Math.max(heights[minindex] * (end - start + 1),
                Math.max(calculateArea(heights, start, minindex - 1),
                        calculateArea(heights, minindex + 1, end)));
    }
}
