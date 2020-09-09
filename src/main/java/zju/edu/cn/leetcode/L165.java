package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/24 20:17
 * @strategy split + 迭代
 * >> split() 对于特殊字符需要添加 \\
 */
public class L165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int i = 0;
        for (; len1 > 0 && len2 > 0; len1--, len2--, i++) {
            int value1 = Integer.parseInt(v1[i]);
            int value2 = Integer.parseInt(v2[i]);
            if (value1 > value2) {
                return 1;
            }
            if (value1 < value2) {
                return -1;
            }
        }
        if (len1 > 0) {
            while (len1 > 0) {
                if (Integer.parseInt(v1[i]) > 0) {
                    return 1;
                }
                i++;
                len1--;
            }
        } else {
            while (len2 > 0) {
                if (Integer.parseInt(v2[i]) > 0) {
                    return -1;
                }
                i++;
                len2--;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        L165 L = new L165();
        System.out.println(L.compareVersion("0.1", "1.1"));
    }
}
