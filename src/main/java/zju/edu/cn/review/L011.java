package zju.edu.cn.review;

/**
 * @author cnxsliu
 * @date 2020/6/29 15:56
 * 双指针
 * 选择高度小的索引位置向中间推进
 */
public class L011 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left != right) {
            int cur = Math.min(height[right], height[left]) * (right - left);
            area = Math.max(area, cur);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}