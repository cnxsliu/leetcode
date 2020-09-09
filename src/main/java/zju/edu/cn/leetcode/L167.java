package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 15:35
 * @strategy 双指针
 * >> left = 0, right = numbers.length - 1
 */
public class L167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] numbers, int target) {
        int len = numbers.length;
        int[] res = new int[2];
        loop : for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (numbers[i] + numbers[j] == target) {
                    // 不是从 0 开始的
                    res[0] = i + 1;
                    res[1] = j + 1;
                    break loop;
                }
            }
        }
        return res;
    }
}
