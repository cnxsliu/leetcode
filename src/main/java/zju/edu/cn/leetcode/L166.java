package zju.edu.cn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 15:10
 * @strategy 长除法
 * >> 数据结构：HashMap, StringBuilder, long
 */
public class L166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder faction = new StringBuilder();
        // 异或 ^ 用得好
        if (numerator < 0 ^ denominator < 0) {
            faction.append("-");
        }
        // 防止溢出，转成 long 类型
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        faction.append(dividend / divisor);
        long remainder = dividend % divisor;
        // 判断是否可以整除
        if (remainder == 0) {
            return faction.toString();
        }
        faction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        // 如果为 0，表示为有限小数
        while (remainder != 0) {
            // 表示找到循环起点
            if (map.containsKey(remainder)) {
                faction.insert(map.get(remainder), "(");
                faction.append(")");
                break;
            }
            // 保存小数及其位置
            map.put(remainder, faction.length());
            remainder *= 10;
            faction.append(remainder / divisor);
            remainder = remainder % divisor;
        }
        return faction.toString();
    }
}
