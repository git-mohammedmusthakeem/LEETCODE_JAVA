class MapSum {

    private static class Node{
        int count;
        Node[] childs;
        boolean isLeaf;
        public Node(){
            this.childs = new Node[26];
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        char[] arr = key.toCharArray();
        Node node = root;
        for(int i = 0; i < arr.length; i++){
            int c = arr[i] - 'a';
            if(node.childs[c] == null){
                node.childs[c] = new Node();
            }
            node = node.childs[c];
        }
        node.isLeaf = true;
        node.count = val;
    }

    public int sum(String prefix) {
        char[] arr = prefix.toCharArray();
        Node node = root;
        for(int i = 0; i < arr.length; i++){
            int c = arr[i] - 'a';
            if(node.childs[c] == null){
                return 0;
            }else{
                node = node.childs[c];
            }
        }
        return childsCount(node);
    }
    private int childsCount(Node node){
        int count = node.count;
        for(int i = 0; i < 26; i++){
            if(node.childs[i] != null){
                count += childsCount(node.childs[i]);
            }
        }
        return count;
    }
}