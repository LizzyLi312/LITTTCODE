class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.next[c - 'a'] == null) {
                p.next[c - 'a'] = new TrieNode();
            }
            p = p.next[c - 'a'];
        }
        p.lastChar = true;
    }
    
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode n : p.next) {
                    if(n != null && sear(word.substring(i + 1), n)) return true;
                }
                return false;
            }
            if (p.next[c - 'a'] == null) return false;
            p = p.next[c - 'a'];
        }
        return p.lastChar;
    }

    private boolean sear(String s, TrieNode p) {
        if (s.isEmpty()) return p.lastChar; // base case

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                for (TrieNode n : p.next) {
                    if (n != null && sear(s.substring(i + 1), n)) return true;
                }
                return false;
            }
            if (p.next[c - 'a'] == null) return false;
            p = p.next[c - 'a'];
        }
        return p.lastChar;
    }

    class TrieNode {
        TrieNode[] next;
        boolean lastChar;
        public TrieNode() {
            next = new TrieNode[26];
            lastChar = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
