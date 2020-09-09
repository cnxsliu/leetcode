package zju.edu.cn.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cnxsliu
 * @date 2020/6/20 16:59
 * 哈希表 + 一次迭代
 */
public class L001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum Solution");
    }
}
