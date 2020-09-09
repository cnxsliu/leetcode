package zju.edu.cn.leetcode;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/21 21:09
 * @strategy 暴力法
 * >> Pair，表示一对数据
 */
public class L149 {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int i = 0;
        for (; i < points.length - 1; i++) {
            if (points[i][0] != points[i + 1][0] || points[i][1] != points[i + 1][1]) {
                break;
            }
        }
        // 如果所有点都重合，直接返回 points.length
        if (i == points.length - 1) {
            return points.length;
        }
        int max = 0;
        for (i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                // 不考虑重合的点
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                // 找到所有和这两个不重合点共线的点
                int tempMax = 0;
                for (int k = 0; k < points.length; k++) {
                    if (k != i && k != j) {
                        if (test(points[i][0], points[i][1],points[j][0], points[j][1],points[k][0], points[k][1])) {
                            tempMax++;
                        }
                    }
                }
                max = Math.max(max, tempMax);
            }
        }
        return max + 2;
    }

    /**
     * 测试点 (x, y) 是否在线上，(y2-y1)/(x2-x1) = (y-y2)/(x-x2)，将式子约分化简，比较值是否相等
     * @param x1 x1
     * @param y1 y1
     * @param x2 x2
     * @param y2 y2
     * @param x x
     * @param y y
     * @return boolean
     */
    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        int g1 = gcd(y2 - y1, x2 - x1);
        if (y == y2 && x == x2) {
            return true;
        }
        int g2 = gcd(y - y2, x - x2);
        return (y2 - y1) / g1 == (y - y2) /g2 && (x2 - x1) / g1 == (x - x2) / g2;
    }

    /**
     * 辗转相除法：求最大公约数
     * @param a 变量 a
     * @param b 变量 b
     * @return int
     */
    private int gcd (int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }


    /**
     * 官方解法，存在精度问题
     */
    private int[][] points;
    private int n;
    private HashMap<Double, Integer> lines = new HashMap<>();
    private int horizontalLines;

    public int maxPoints2(int[][] points) {
        this.points = points;
        n = points.length;
        if (n < 3) {
            return n;
        }
        int maxCount = 1;
        for (int i = 0; i < n - 1; i++) {
            maxCount = Math.max(maxCount, maxPointsOnLineContainingPoint(i));
        }
        return maxCount;
    }

    private int maxPointsOnLineContainingPoint(int i) {
        lines.clear();
        horizontalLines = 1;
        int count = 1;
        int duplicates = 0;
        for (int j = i + 1; j < n; j++) {
            Pair<Integer, Integer> p = addLine(i, j, count, duplicates);
            count = p.getKey();
            duplicates = p.getValue();
        }
        return count + duplicates;
    }

    private Pair<Integer, Integer> addLine(int i , int j, int count, int duplicates) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        if (x1 == x2 && y1 == y2) {
            duplicates++;
        } else if (y1 == y2) {
            horizontalLines++;
            count = Math.max(count, horizontalLines);
        } else {
            double slope = 1.0 * (x1 - x2) / (y1 - y2) + 0.0;
            lines.put(slope, lines.getOrDefault(slope, 1) + 1);
            count = Math.max(count, lines.get(slope));
        }
        return new Pair<>(count, duplicates);
    }
}
