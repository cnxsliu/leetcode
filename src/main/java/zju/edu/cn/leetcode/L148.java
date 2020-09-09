package zju.edu.cn.leetcode;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/21 16:36
 * @strategy
 */
public class L148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = getListLen(head);
        int subLen = 1;
        while (subLen < len) {
            ListNode pre = dummy;
            ListNode h = dummy.next;
            while (h != null) {
                int i = subLen;
                ListNode h1 = h;
                for (; h != null && i > 0; i--) {
                    h = h.next;
                }
                if (i > 0) {
                    break;
                }
                ListNode h2 = h;
                i = subLen;
                for (; h != null && i > 0; i--) {
                    h = h.next;
                }
                int c1 = subLen;
                int c2 = subLen - i;
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                pre.next = c1 > 0 ? h1 : h2;
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = h;
            }
            subLen *= 2;
        }
        return dummy.next;
    }

    private int getListLen(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }


    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode start = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        int[] arr = new int[len];
        head = start;
        for (int i = 0; i < len; i++) {
            arr[i] = head.val;
            head = head.next;
        }
        Arrays.sort(arr);
        head = start;
        for (int i = 0; i < len; i++) {
            head.val = arr[i];
            head = head.next;
        }
        return start;
    }
}
