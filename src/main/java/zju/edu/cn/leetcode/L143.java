package zju.edu.cn.leetcode;

import java.util.LinkedList;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/20 16:08
 * @strategy
 */
public class L143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        LinkedList<ListNode> queue = new LinkedList<>();
        while (head != null) {
            queue.addLast(head);
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        head = queue.pollFirst();
        while (queue.size() > 0) {
            head.next = queue.pollLast();
            head = head.next;
            if (queue.size() > 0) {
                head.next = queue.pollFirst();
                head = head.next;
            }
        }
    }
}
