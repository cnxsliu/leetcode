package zju.edu.cn.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/25 23:23
 * @strategy 回溯法，深度优先搜索
 * >> 将最终的结果定义为类的成员变量
 * >> 定义一个标记数组，对走过的路径进行标记
 * >> 使用栈 ArrayDeque对临时结果进行存储，在保存到result之前转成 ArrayList
 * >> 深度优先搜索本质就是：递归 + 迭代
 */
public class L046 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flag[i] = false;
        }
        dfs(nums, new ArrayDeque<>(), flag);
        return result;
    }

    public void  dfs(int[] nums, ArrayDeque<Integer> arr, boolean[] flag) {
        if (arr.size() == nums.length) {
            result.add(new ArrayList<>(arr));
            return ;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (flag[i]) {
                continue;
            }
            arr.push(nums[i]);
            flag[i] = true;
            dfs(nums, arr, flag);
            arr.pop();
            flag[i] = false;
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        L046 L = new L046();
        System.out.println(L.permute(arr));
    }
}
