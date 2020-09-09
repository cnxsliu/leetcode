package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/28 19:25
 * @strategy 树
 * >> 每棵树都有一个 next 的树数组，表示当前节点的子节点
 * >> 由于只有 26 个字母，所以直接创建的是 new Trie[26]
 * >> 同时，每棵树还会维护一个 isString 的布尔型变量，用来表示到该位置的字符是否组成一个 word
 */
public class L208 {
    class Trie {
        private Trie[] next = new Trie[26];
        private boolean isString = false;

        public Trie(){
        }

        public void insert (String word) {
            Trie root = this;
            char[] w = word.toCharArray();
            for (int i = 0; i < w.length; i++) {
                if (root.next[w[i] - 'a'] == null) {
                    root.next[w[i] - 'a'] = new Trie();
                }
                root = root.next[w[i] - 'a'];
            }
            root.isString = true;
        }

        public boolean search (String word) {
            Trie root = this;
            char[] w = word.toCharArray();
            for (int i = 0; i < w.length; i++) {
                if (root.next[w[i] - 'a'] == null) {
                    return false;
                }
                root = root.next[w[i] - 'a'];
            }
            return root.isString;
        }

        public boolean startsWith (String prefix) {
            Trie root = this;
            char[] p = prefix.toCharArray();
            for (int i = 0; i < p.length; i++) {
                if (root.next[p[i] - 'a'] == null) {
                    return false;
                }
                root = root.next[p[i] - 'a'];
            }
            return true;
        }
    }
}
