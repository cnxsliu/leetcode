package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/5 21:41
 * @strategy 链表迭代
 */
public class L082 {
    public ListNode deleteDuplicates(ListNode head) {
        //创建空节点，指向头结点，防止头结点被删
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        L082 L = new L082();
        ListNode L1 = new ListNode(1);
        ListNode L2 = new ListNode(2);
        ListNode L3 = new ListNode(3);
        ListNode L4 = new ListNode(3);
        ListNode L5 = new ListNode(4);
        ListNode L6 = new ListNode(4);
        ListNode L7 = new ListNode(5);
        L1.next = L2;
        L2.next = L3;
        L3.next = L4;
        L4.next = L5;
        L5.next = L6;
        L6.next = L7;
        System.out.println(L.deleteDuplicates(L1));
    }
}
