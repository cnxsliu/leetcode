package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/29 16:05
 * @strategy 数组排序 + 迭代
 * >> 注意对数组按照首个元素进行排序的方法 Arrays.sort(intervals, (a, b) -> a[0] - b[0])
 * >> 将链表转化成数组 res.toArray(new int[0][])
 */
public class L056 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList();
        if (intervals.length == 0 || intervals == null) {
            return res.toArray(new int[0][]);
        }
        //使用Lamda表达式对数组进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
