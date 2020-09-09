package zju.edu.cn.leetcode;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/20 17:14
 * @strategy 双向链表 + 哈希
 * >> 使用了伪头部和伪尾部
 * >> addNode, removeNode, moveToHead, popTail
 * >> get, put
 */
public class L146 {
    class LRUCache {

        class DequeLinkedNode{
            int key;
            int val;
            DequeLinkedNode prev;
            DequeLinkedNode next;
        }

        private Hashtable<Integer, DequeLinkedNode> cache = new Hashtable<>();
        private int size;
        private int capacity;
        private DequeLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DequeLinkedNode();
            tail = new DequeLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        private void addNode(DequeLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DequeLinkedNode node) {
            DequeLinkedNode prev = node.prev;
            DequeLinkedNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DequeLinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        private DequeLinkedNode popTail() {
            DequeLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        public int get(int key) {
            DequeLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int val) {
            DequeLinkedNode node = cache.get(key);
            if (node == null) {
                DequeLinkedNode newNode = new DequeLinkedNode();
                newNode.key = key;
                newNode.val = val;
                cache.put(key, newNode);
                addNode(newNode);
                size++;
                if (size > capacity) {
                    DequeLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                node.val = val;
                moveToHead(node);
            }
        }
    }


    class LRUCache2 extends LinkedHashMap<Integer, Integer> {
        private int capacity;
        public LRUCache2(int capacity) {
            // 必须先写父类构造方法
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
