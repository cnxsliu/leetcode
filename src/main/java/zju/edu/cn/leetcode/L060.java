package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/30 22:14
 * @strategy 阶乘数系统
 * >> 关键在于将一个十进制数转为 n 位的阶乘数
 */
public class L060 {
    public String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        List<Integer> nums = new ArrayList();
        nums.add(1);
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
            nums.add(i + 1);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > -1; i--) {
            // 用 k 除以阶乘数，将结果将决定选取 1-n 的第几个数，
            // 将结果拼接到 sb 后面，并将该数字从 nums 中移除
            int idx = k / factorials[i];
            k -= idx * factorials[i];
            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }
}
