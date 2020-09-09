package zju.edu.cn.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 21:51
 * @strategy 自定义比较器：字符串比较
 * >> 实现 Comparator<String>
 */
public class L179 {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new MyComparator());
        if ("0".equals(arr[0])) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
        }
        return res.toString();
    }

    class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);
        }
        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

}
