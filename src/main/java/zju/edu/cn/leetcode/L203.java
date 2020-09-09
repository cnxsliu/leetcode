package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/28 15:52
 * @strategy 双指针
 * >> 只需要定义 pre 和 cur 即可进行遍历
 * >> 需要定义一个 dummyHead，防止头结点被删除
 */
public class L203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || (head.val == val && head.next == null)) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
