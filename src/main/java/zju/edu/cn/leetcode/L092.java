package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/9 14:04
 * @strategy 迭代 + 反转链表
 */
public class L092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n == m) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        //将此时 prev 和 cur 的位置保存起来
        ListNode con = prev, tail = cur;
        ListNode third = null;
        //下面是经典的链表反转方式
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }
}
