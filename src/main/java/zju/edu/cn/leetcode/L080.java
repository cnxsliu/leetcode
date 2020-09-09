package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/5 16:47
 * @strategy 双指针法
 */
public class L080 {
    public int removeDuplicates(int[] nums) {
        int left = 1;
        int right = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;

            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[left] = nums[right];
                left++;
                right++;
            } else {
                right++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        L080 L = new L080();
        int[] arr = {0,0,1,1,1,1,2,3,3};
        System.out.println(L.removeDuplicates(arr));
    }
}
