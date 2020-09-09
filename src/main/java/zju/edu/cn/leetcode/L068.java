package zju.edu.cn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/3 15:35
 * @strategy 直观法
 */
public class L068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList();
        List<String> temp = new ArrayList<>();
        int width = 0;
        for (int i = 0; i < words.length; i++) {
            if (width == 0) {
                width += words[i].length();
                temp.add(words[i]);
                if (i == words.length - 1) {
                    res.add(merge(maxWidth, width, temp, true));
                }
                continue;
            }
            if (width + words[i].length() + 1 <= maxWidth) {
                width += words[i].length() + 1;
                temp.add(words[i]);
                if (i == words.length - 1) {
                    res.add(merge(maxWidth, width, temp, true));
                }
            }
            else {
                i--;
                res.add(merge(maxWidth, width, temp, false));
                temp.clear();
                width = 0;
            }
        }
        return res;
    }

    private String merge(int maxWidth, int width, List<String> temp, boolean last) {
        StringBuilder sb = new StringBuilder();
        if (temp.size() == 1) {
            sb.append(temp.get(0));
            for (int i = width; i < maxWidth; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        if (last) {
            for (int i = 0; i < temp.size(); i++) {
                sb.append(temp.get(i));
                if (i == temp.size() - 1 && width == maxWidth) {
                    return sb.toString();
                }
                sb.append(" ");
            }
            for (int i = width + 1; i < maxWidth; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        int left = maxWidth - width;
        int n1 = 0;
        int n2 = 0;

        n1 = left / (temp.size() - 1);
        n2 = left % (temp.size() - 1);

        sb.append(temp.get(0));

        for (int j = 1; j <= n2; j++) {
            for (int k = 0; k < n1; k++) {
                sb.append(" ");
            }
            sb.append("  ");
            sb.append(temp.get(j));

        }
        for (int j = n2 + 1; j < temp.size(); j++) {
            for (int k = 0; k < n1; k++) {
                sb.append(" ");
            }
            sb.append(" ");
            sb.append(temp.get(j));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L068 L = new L068();
        String[] arr = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] arr2 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        String[] arr3 = {"10000","1000000000"};
        String[] arr4 = {"What","must","be","acknowledgment","shall","be"};
        //System.out.println(L.fullJustify(arr, 16));
        System.out.println(L.fullJustify(arr2, 20));
    }
}
