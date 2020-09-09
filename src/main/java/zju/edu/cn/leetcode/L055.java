package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/28 22:40
 * @strategy 贪心法
 * >> 注意非空数组的判断，和特殊数组输入的处理
 */
public class L055 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1 && nums[0] == 0) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }

        int index = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (index >= nums.length - 1) {
                return true;
            }
            if (i < index) {
                sum = Math.max(sum, i + nums[i]);
            } else {
                sum = Math.max(sum, i + nums[i]);
                if (sum <= index) {
                    return false;
                }
                index = sum;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0};
        int[] arr2 = {3,2,1,0,4};
        L055 L = new L055();
        System.out.println(L.canJump(arr));
//        System.out.println(L.canJump(arr2));
    }
}
