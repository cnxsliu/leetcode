package zju.edu.cn.review;

/**
 * @author cnxsliu
 * @date 2020/6/23 18:02
 */
public class L009 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] arr = String.valueOf(x).toCharArray();
        int len = arr.length;
        int index = 0;
        while (index < len / 2) {
            if (arr[index] == arr[len - index - 1]) {
                index++;
            } else {
                return false;
            }
        }
        return true;
    }
}
