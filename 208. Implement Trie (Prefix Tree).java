class Trie {
    private static class TrieNode{
        boolean isLeaf;
        TrieNode[] childs;
        public TrieNode(){
            childs = new TrieNode[26];
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        TrieNode temp = root;
        for(int i = 0; i < len; i++){
            int c = word.charAt(i) - 'a';
            if(temp.childs[c] == null){
                temp.childs[c] = new TrieNode();
            }
            temp = temp.childs[c];
        }
        temp.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() == 0) return true;
        int len = word.length();
        TrieNode temp = this.root;
        for(int i = 0; i < len; i++){
            int c = word.charAt(i) - 'a';
            if(temp.childs[c] == null) return false;
            else temp = temp.childs[c];
        }
        return temp.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) return false;
        int len = prefix.length();
        TrieNode temp = root;
        for(int i = 0; i < len; i++){
            int c = prefix.charAt(i) - 'a';
            if(temp.childs[c] == null) return false;
            temp = temp.childs[c];
        }
        return true;
    }
}