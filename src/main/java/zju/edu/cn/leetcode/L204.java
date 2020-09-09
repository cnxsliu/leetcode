package zju.edu.cn.leetcode;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/28 16:08
 * @strategy 过程优化
 * >> 只需要遍历 2 到 sqrt(n) 之间的情况即可
 */
public class L204 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n ; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
