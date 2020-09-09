package zju.edu.cn.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/23 18:05
 * @strategy 回溯法
 * >> 由于要在回溯过程中随时保存可行解，将结果集定义为类属性，避免在方法中一直传递
 * >> Stack、ArrayDeque（栈）可以直接赋给一个ArrayList的构造函数
 */
public class L039 {
    /**
     * 只用于保存结果，单独分离出来
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return res;
        }
        dfs(target, 0, new ArrayDeque<Integer>(), candidates);
        return res;
    }

    /**
     * 深度优先
     * @param target 目标值，在遍历过程中不断削减，直到达到最优值
     * @param index 索引，用于for循环中，为了防止重复遍历
     * @param pre 栈，用于保存临时遍历结构
     * @param candadites 输入的数组
     */
    private void dfs(int target, int index, ArrayDeque<Integer> pre, int[] candadites) {
        if (target == 0) {
            res.add(new ArrayList<>(pre));
            return;
        }

        for (int i = index; i < candadites.length; i++) {
            if (candadites[i] <= target) {
                //往临时栈中添加元素
                pre.push(candadites[i]);
                dfs(target - candadites[i], i , pre, candadites);
                //从临时栈中移除元素
                pre.pop();
            }
        }
    }
}
