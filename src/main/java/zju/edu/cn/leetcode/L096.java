package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/9 16:53
 * @strategy 动态规划
 * >> G(n) = ∑ G(i - 1) * G(n - i)
 * >> 回溯法的缺点是速度慢
 */
public class L096 {
    public int numTrees2(int n) {
        return recurse(1, n);
    }

    private int recurse(int start, int end) {
        int sum = 0;
        if (start > end) {
            return 1;
        }
        for (int i = start; i <= end; i++) {
            int left = recurse(start, i - 1);
            int right = recurse(i + 1, end);
            sum += left * right;
        }
        return sum;
    }

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        L096 L= new L096();
        System.out.println(L.numTrees(18));
    }
}
