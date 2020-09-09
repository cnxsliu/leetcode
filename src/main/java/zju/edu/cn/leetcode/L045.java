package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/25 22:30
 * @strategy 贪心法
 * >> 两种策略：从左往右找，1、每次下一步可以跳得最远的；2、最先找到可以跳到终点的
 * >> 贪心算法由于是找的局部最优解，所以也不容易产生死循环
 */
public class L045 {
    public static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        // 设定在每次可以起跳时加一，最后一次落地不需要加一
        // 由于必须在起跳位置加一，所以 end 初始化时必须是0，即起跳就加一
        for (int i = 0;i < nums.length - 1; i++) {
            //贪心贪的是 nums[i] + i
            maxPosition = Math.max(maxPosition, nums[i] + i);
            //当每次到达上次可以跳的最远位置时，可以将 end 更新为下一次可以跳的最远位置
            if (i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,1,1,4};
        System.out.println(jump(arr));
    }
}
