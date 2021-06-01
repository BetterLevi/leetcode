package lc;

/**
 * 实现前缀树（Trie）
 * @author wei.liang
 * @since 2021/5/23
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return true;
    }


    private static class TrieNode {
        private Boolean isEnd;
        private TrieNode[] next;

        public TrieNode() {
            this.isEnd = false;
            this.next = new TrieNode[26];
        }

        public Boolean getEnd() {
            return isEnd;
        }

        public void setEnd(Boolean end) {
            isEnd = end;
        }

        public TrieNode[] getNext() {
            return next;
        }

        public void setNext(TrieNode[] next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("word");
    }
}
