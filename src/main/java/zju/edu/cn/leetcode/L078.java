package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/5 15:35
 * @strategy 回溯法
 * >> 删除链表中的元素是按照下标来删的，通常要先在链表中找到对应元素的下标，
 *    有 2 中方式 ：temp.indexOf(); temp.size() - 1
 */
public class L078 {
    List<List<Integer>> res ;
    List<Integer> temp;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        res.add(new ArrayList<>(temp));
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(0, nums);
        return res;
    }

    private void dfs(int idx, int[] nums) {
        if (idx > nums.length - 1) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (!temp.contains(nums[i]) && (temp.isEmpty() || temp.get(temp.size() - 1) < nums[i])) {
                temp.add(nums[i]);
                res.add(new ArrayList<>(temp));
                dfs(idx + 1, nums);
                temp.remove(temp.indexOf(nums[i]));
            }
        }
    }

    public static void main(String[] args) {
        L078 L= new L078();
        int[] arr = {1,2,3};
        System.out.println(L.subsets(arr));
    }
}
