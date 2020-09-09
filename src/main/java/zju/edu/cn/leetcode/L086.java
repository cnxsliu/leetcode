package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/7 14:59
 * @strategy 迭代
 * >> 设置一个标志位，在迭代到最后一个元素的时候，根据标志位进行重置和终止
 */
public class L086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = head;
        boolean flag = false;
        while (true) {
            if (head.next == null) {
                if (flag) {
                    head = start;
                    flag = false;
                } else {
                    break;
                }

            }
            if (head.val >= x && head.next.val < x) {
                int temp = head.val;
                head.val = head.next.val;
                head.next.val = temp;
                flag = true;
            }
            head = head.next;
        }
        return start;
    }
}
