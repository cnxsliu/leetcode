package zju.edu.cn.leetcode;

import java.util.HashSet;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/24 17:53
 * @strategy
 */
public class L160 {
    /**
     * 双指针法
     * @param headA headA
     * @param headB headB
     * @return ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode startA = headA;
        ListNode startB = headB;
        while (true) {
            if (headA == headB) {
                return headA;
            }
            // 必须是 headA == null，而不能是 headA.next == null
            if (headA == null) {
                headA = startB;
            } else {
                headA = headA.next;
            }
            if (headB == null) {
                headB = startA;
            } else {
                headB = headB.next;
            }
        }
    }

    /**
     * 哈希表
     * @param headA headA
     * @param headB headB
     * @return ListNode
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> setA = new HashSet<>();
        HashSet<ListNode> setB = new HashSet<>();
        while (true) {
            if (headA == null && headB == null) {
                return null;
            }
            if (setB.contains(headA)) {
                return headA;
            }
            if (headA != null) {
                setA.add(headA);
                headA = headA.next;
            }
            if (setA.contains(headB)) {
                return headB;
            }
            if (headB != null) {
                setB.add(headB);
                headB = headB.next;
            }
        }
    }
}
