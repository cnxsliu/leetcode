package zju.edu.cn.leetcode;


/**
 * @author cnxsliu
 * @description
 * @date 2020/5/2 14:49
 * @strategy 将链表成环再打开
 * >> 注意 for 循环的终止条件可以灵活一些
 */
public class L061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode old_tail = head;
        int num;
        for (num = 1; old_tail.next != null; num++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;
        ListNode new_tail = head;
        for (int i = 0; i < num - k % num - 1; i++) {
            new_tail = new_tail.next;
        }
        head = new_tail.next;
        new_tail.next = null;
        return head;
    }
}
