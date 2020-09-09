package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/29 17:51
 * @strategy 贪心，迭代
 * >> 为了可以剔除掉结果集合中的最后一个元素，进行灵活合并操作，使用了 LinkedList 的 removeLast() 方法
 * >> LinkedList 在通过 toArray() 转化为数组的时候，需要分配一个二维数组的空间参数
 */
public class L057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<>();
        //比较各个区间和插入区间的起点，如果插入区间起点更大，则将已有区间插入
        while (idx < n && newStart > intervals[idx][0]) {
            output.add(intervals[idx++]);
        }
        int[] interval;
        //比较插入区间起点和前面已有区间的终点的大小，分类讨论
        if (output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);
        }
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            if (output.getLast()[1] < start) {
                output.add(interval);
            } else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }
}
