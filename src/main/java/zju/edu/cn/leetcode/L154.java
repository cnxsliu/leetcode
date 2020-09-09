package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/24 16:54
 * @strategy 二分查找 + 迭代
 * >> 当 nums[mid] == nums[right]，采用迭代
 */
public class L154 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 注意：>> 的优先级比 + 小
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                // nums[mid] == nums[right]，这种情况较复杂，采用迭代，复杂度升高为 O(n)
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        L154 L = new L154();
        int[] arr = {2,2,2,0,1};
        System.out.println(L.findMin(arr));
    }
}
