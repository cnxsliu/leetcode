package zju.edu.cn.leetcode;

import java.util.HashSet;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/16 15:15
 * @strategy Hash查找
 * >> 使用 HashSet 将 nums 中的元素存储起来
 * >> 对 nums 中的元素进行遍历，只对 num - 1 不存在的元素进行连续长度计算
 */
public class L128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curStreak = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curStreak++;
                }
                longestStreak = Math.max(longestStreak, curStreak);
            }
        }
        return longestStreak;
    }
}
