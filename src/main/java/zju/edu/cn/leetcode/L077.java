package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/4 20:03
 * @strategy 回溯法
 * >> 在想 List中添加对象的时候，必须要新建一个对象保存进去，如果一直使用一个对象，则之前的值会动态改变，
 *    和该对象的最后一次的内容一致。
 */
public class L077 {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return res;
        }
        dfs(n, k, 1, 0, temp);
        return res;
    }

    private void dfs(int n, int k,int num, int count, List<Integer> temp) {
        if (count == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (k - count > n - num + 1) {
            return;
        }
        for (int i = num; i <= n; i++) {
            temp.add(i);
            dfs(n, k, i + 1, ++count, temp);
            temp.remove(temp.indexOf(i));
            count--;
        }
    }

    public static void main(String[] args) {
        L077 L = new L077();
        System.out.println(L.combine(4,2));
    }
}
