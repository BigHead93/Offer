package code;

public class lc208_ImplementTrie_PrefixTree {
    class Trie {

        class Node {
            char c;
            Node next;
            Node firstc;
            boolean finish;

            Node(char c) {
                this.c = c;
            }
        }

        Node treeNode;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            treeNode = new Node('0');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0)
                return;
            Node pre = treeNode;
            Node now = treeNode.firstc;
            int i = 0;
            while (now != null) {
                if (word.charAt(i) == now.c) {
                    if (i == word.length() - 1) {
                        now.finish = true;
                        return;
                    }
                    pre = now;
                    now = now.firstc;
                    i++;
                } else if (now.next != null) {
                    now = now.next;
                } else {
                    now.next = new Node(word.charAt(i));
                    pre = now.next;
                    now = pre.firstc;
                    i++;
                }
            }
            if (now == null) {
                if(i != word.length()) {
                    for (; i < word.length(); i++) {
                        pre.firstc = new Node(word.charAt(i));
                        pre = pre.firstc;
                    }
                }
                pre.finish = true;
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0)
                return true;
            Node pre = treeNode;
            Node now = treeNode.firstc;
            int i = 0;
            while (now != null) {
                if (word.charAt(i) == now.c) {
                    if (i == word.length() - 1) {
                        return now.finish == true;
                    }
                    pre = now;
                    now = now.firstc;
                    i++;
                } else {
                    now = now.next;
                }
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0)
                return true;
            Node pre = treeNode;
            Node now = treeNode.firstc;
            int i = 0;
            while (now != null) {
                if (prefix.charAt(i) == now.c) {
                    if (i == prefix.length() - 1) {
                        return true;
                    }
                    pre = now;
                    now = now.firstc;
                    i++;
                } else {
                    now = now.next;
                }
            }
            return false;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static void main(String[] args) {
        lc208_ImplementTrie_PrefixTree test = new lc208_ImplementTrie_PrefixTree();
        Trie obj = test.new Trie();
        obj.insert("app");
//        obj.insert("apple");
        obj.insert("applea");
        obj.insert("bear");
        obj.insert("add");
        obj.insert("jam");
        obj.insert("rental");
        boolean b1 = obj.search("applea");
        assert b1 = true;
        boolean b2 = obj.search("app");
        boolean b3 = obj.startsWith("app");

        obj.insert("app");
        boolean b4 = obj.search("app");
        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4);
    }
}
