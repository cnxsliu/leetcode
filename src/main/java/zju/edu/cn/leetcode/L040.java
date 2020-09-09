package zju.edu.cn.leetcode;

import java.util.*;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/23 18:37
 * @strategy 回溯法
 * >> 在for循环内，也就水平方向上对树进行剪枝 **
 * >> 为了实现结果不重复，需要对数组进行排序，并在for循环中进行过滤
 */
public class L040 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(target, 0, new ArrayDeque<>(), candidates);
        return res;
    }

    private void dfs(int target, int index, ArrayDeque<Integer> pre, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(pre));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            else if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            else if (candidates[i] <= target ) {
                pre.push(candidates[i]);
                dfs(target - candidates[i], i + 1, pre, candidates);
                pre.pop();
            }
        }
    }


}

