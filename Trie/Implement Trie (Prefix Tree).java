//see root is a empty node. compare the first character with root.children
class Trie {
    class TrieNode{
        public boolean isLeaf;
        public char c;
        public TrieNode[] children;
        public TrieNode(){
            isLeaf = false;
            c = '\0';
            children = new TrieNode[26];
        }
        public TrieNode(char c){
            this.c = c;
        }
    }
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null){
                cur.children[idx] = new TrieNode(word.charAt(i));
            }
           cur = cur.children[idx];
        }
        cur.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null) return false;
            else cur = cur.children[c - 'a'];
        }
        return cur.isLeaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if(cur.children[c - 'a'] == null) return false;
            else cur = cur.children[c - 'a'];
        }
        return true;
    }
}

//time: length of word 
