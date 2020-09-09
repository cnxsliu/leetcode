package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/7 19:23
 * @strategy 回溯法
 */
public class L090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>(list));
        dfs(res, list, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int idx) {
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            if (!res.contains(list)) {
                res.add(new ArrayList<>(list));
            }
            dfs(res, list, nums, i + 1);
            list.remove((Integer) nums[i]);
        }
    }

    public static void main(String[] args) {
        L090 L = new L090();
        int[] arr = {1,2,2};
        System.out.println(L.subsetsWithDup(arr));
    }
}
