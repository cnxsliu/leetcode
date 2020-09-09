package zju.edu.cn.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/28 15:39
 * @strategy HashSet
 * >> Java中的平方，Math.pow()
 */
public class L202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (n == 1) {
                return true;
            } else {
                int temp = 0;
                while (n != 0) {
                    temp += Math.pow((n % 10), 2);
                    n = n / 10;
                }
                if (set.contains(temp)) {
                    return false;
                }
                set.add(temp);
                n = temp;
            }
        }
    }

    public static void main(String[] args) {
        L202 L = new L202();
        System.out.println(L.isHappy(19));
    }
}
