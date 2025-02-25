class MagicDictionary {
    private static class Node{
        boolean isLeaf;
        Node[] childs;
        public Node(){
            this.childs = new Node[26];
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.root = new Node();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s : dict){
            char[] arr = s.toCharArray();
            Node node = root;
            for(int i = 0; i < arr.length; i++){
                int c = arr[i] - 'a';
                if(node.childs[c] == null){
                    node.childs[c] = new Node();
                }
                node = node.childs[c];
            }
            node.isLeaf = true;
        }
    }
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        return dfs(word, 0, root, 0);
    }
    private boolean dfs(String word, int index, Node node, int diff){
        if(diff > 1) return false;
        if(index == word.length()){
            if(diff == 1 && node.isLeaf){
                return true;
            }else{
                return false;
            }
        }
        int c = word.charAt(index) - 'a';
        boolean res = false;
        for(int i = 0; i < 26; i++){
            if(node.childs[i] != null){
                res |= dfs(word, index + 1, node.childs[i], diff + (c == i ? 0: 1));
            }
        }
        return res;
    }
}