package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/4 16:43
 * @strategy 二分查找的变形
 * >> 注意输入参数非空校验
 * >> 将二维数组转化为一维数组，然后进行二分查找
 * >>
 */
public class L074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] arr = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i * col + j] = matrix[i][j];
            }
        }
        return binarySearch(arr, 0, row * col - 1, target);
    }

    private boolean binarySearch(int[] arr,int left, int right, int target) {
        if (arr[left] == target || arr[right] == target) {
            return true;
        }
        if (arr[left] > target || arr[right] < target || left > right) {
            return false;
        }
        int mid = left + (right - left) >> 1;
        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] > target) {
            return binarySearch(arr, left + 1, mid, target);
        } else if (arr[mid] < target) {
            return binarySearch(arr, mid, right - 1, target);
        }
        return false;
    }
}
