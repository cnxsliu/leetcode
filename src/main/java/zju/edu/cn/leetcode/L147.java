package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/20 20:23
 * @strategy 双指针
 */
public class L147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftHead = head;
        ListNode rightHead = head.next;
        leftHead.next = null;
        while (rightHead != null) {
            leftHead = head;
            if (leftHead.val > rightHead.val) {
                ListNode temp = rightHead;
                rightHead = rightHead.next;
                temp.next = leftHead;
                leftHead = temp;
                head = leftHead;
                continue;
            }
            while (leftHead.next != null) {
                if (leftHead.val <= rightHead.val && rightHead.val <= leftHead.next.val) {
                    break;
                }
                leftHead = leftHead.next;
            }
            ListNode temp = rightHead;
            rightHead = rightHead.next;
            temp.next = leftHead.next;
            leftHead.next = temp;
        }
        return head;
    }
}
