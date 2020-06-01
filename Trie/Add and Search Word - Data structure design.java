class WordDictionary {
    
    private class TrieNode{
        private TrieNode[] neighbor;
        private char val;
        private boolean isLeaf;
        public TrieNode(char c){
            val = c;
            neighbor = new TrieNode[26];
            isLeaf = false;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('\0');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word.length() == 0) return;
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.neighbor[c - 'a'] == null) cur.neighbor[c - 'a'] = new TrieNode(c);
            cur = cur.neighbor[c - 'a'];
        }
        cur.isLeaf = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    private boolean dfs(TrieNode cur, String word, int idx){
        int len = word.length();
        if(cur == null) return false;
        if(len == idx) return cur.isLeaf;
        char ch = word.charAt(idx);
        if(ch != '.') return dfs(cur.neighbor[ch - 'a'], word, idx + 1);
        else{
            for(TrieNode nei : cur.neighbor){
                if(dfs(nei, word, idx + 1)) return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
