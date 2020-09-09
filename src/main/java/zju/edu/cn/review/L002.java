package zju.edu.cn.review;

/**
 * @author cnxsliu
 * @date 2020/6/20 17:13
 * 链表迭代
 * 对于第一个节点，要在开始单独处理
 */
public class L002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        int val = l1.val + l2.val;
        ListNode cur = new ListNode(val % 10);
        int carry = val / 10;
        dummyHead.next = cur;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            val = l1.val + l2.val + carry;
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l3 = l1 != null ? l1 : l2;
        while (l3 != null) {
            val = l3.val + carry;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            carry = val / 10;
            l3 = l3.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry % 10);
        }
        return dummyHead.next;
    }
}
