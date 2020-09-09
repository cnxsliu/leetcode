package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/3 17:52
 * @strategy 二分查找
 * >> 对于整数平方运算，要注意 int 范围的问题，可以采用 long 来解决，或者使用 BigDecimal
 * >> 递归实际上可以采用 while 迭代来转换
 */
public class L069 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int count = 0;
        long X = x;
        while (x != 0) {
            x = x / 10;
            count++;
        }
        int n = count % 2;
        long small = 1;
        for (int i = 0; i < count/2; i++) {
            small *= 10;
        }
        if (n == 0) {
            return (int)recurse(small/10, small, X);
        }else {
            return (int)recurse(small, small * 10, X);
        }

    }

    private long recurse(long small, long big, long target) {

        if (small * small == target) {
            return small;
        }
        if (big * big == target) {
            return big;
        }
        if (small * small < target && (small+1) * (small + 1) > target) {
            return small;
        }
        if (big * big > target && (big-1) * (big-1) < target) {
            return big - 1;
        }
        long mid = (small + big) / 2;

        if (mid * mid > target) {
            return recurse(small + 1, mid, target);
        }
        else {
            return recurse(mid, big - 1, target);
        }
    }

    public int mySqrt2(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }


    public static void main(String[] args) {
        L069 L = new L069();
        System.out.println(L.mySqrt(21474_83647));
    }
}
