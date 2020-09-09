package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/23 15:47
 * @strategy String.split()
 */
public class L151 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!"".equals(arr[i])) {
                sb.append(arr[i]).append(" ");
            }
        }
        if (sb.length() != 0 && sb.lastIndexOf(" ") == sb.length() - 1){
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L151 L = new L151();
        String s = "the sky is blue";
        System.out.println(L.reverseWords(s));
    }
}
