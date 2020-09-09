package zju.edu.cn.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/26 15:00
 * @strategy
 */
public class L047 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flag[i] = false;
        }
        dfs(nums, new ArrayDeque<>(), flag);
        return res;
    }

    public void dfs(int[] nums,  ArrayDeque<Integer> arr, boolean[] flag) {
        if (arr.size() == nums.length) {
            res.add(new ArrayList<>(arr));
            System.out.println(arr);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) {
                    //flag[i] = true;
                    continue;
                }
                arr.push(nums[i]);
                flag[i] = true;
                dfs(nums, arr, flag);
                arr.pop();
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args){
        L047 L = new L047();
        int[] arr = {1,1,2};
        System.out.println(L.permuteUnique(arr));

    }

}
