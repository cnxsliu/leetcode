package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/19 21:22
 * @strategy 双指针
 */
public class L142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode met = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                met = fast;
                break;
            }
        }
        if (met == null) {
            return null;
        }
        fast = head;
        while (true) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }
}
