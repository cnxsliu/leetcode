package zju.edu.cn.leetcode;

import java.util.HashMap;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/17 17:41
 * @strategy 迭代 + HashMap的使用
 */
public class L138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = new Node(head.val);
        map.put(head, cur);
        Node start = cur;
        while (head != null) {
            // 添加 random
            if (head.random == null) {
                cur.random = null;
            } else {
                if (map.containsKey(head.random)){
                    cur.random = map.get(head.random);
                } else {
                    Node newRandom = new Node(head.random.val);
                    map.put(head.random, newRandom);
                    cur.random = newRandom;
                }
            }
            // 添加 next
            if (head.next == null) {
                cur.next = null;
                break;
            } else{
                if (map.containsKey(head.next)) {
                    cur.next = map.get(head.next);
                } else {
                    Node newNext = new Node(head.next.val);
                    map.put(head.next, newNext);
                    cur.next = newNext;
                }
            }
            head = head.next;
            cur = cur.next;
        }
        return start;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
