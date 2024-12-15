class Solution {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        for(String s : words)
            insert(s);
        Set<String> res = new HashSet<>();
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, res, new StringBuilder(), i, j, used);
            }
        }
        return new ArrayList<String>(res);
    }
    private void dfs(char[][] board, Set<String> set, StringBuilder sb, int row, int col, boolean[][] used){
        int height = board.length, width = board[0].length;
        if(row >= 0 && row < height && col >= 0 && col < width && !used[row][col]){
            sb.append(board[row][col]);
            String ss = sb.toString();
            if(!hasPrefix(ss)){
                sb.deleteCharAt(ss.length() - 1);
                return;
            }
            if(search(ss)) set.add(ss);
            board[row][col] = true;
            for(int i = 0; i < 4; i++){
                dfs(board, set, sb, row + dir[i][0], col + dir[i][1], used);
            }
            sb.deleteCharAt(sb.toString().length() - 1);
            used[row][col] = false;
        }
    }
    private TrieNode root = new TrieNode();
    private static class TrieNode{
        boolean isLeaf;
        TrieNode[] childs;
        public TrieNode(){
            childs = new TrieNode[26];
        }
    }
    private void insert(String s){
        int len = s.length();
        TrieNode temp = root;
        for(int i = 0; i < len; i++){
            int c = s.charAt(i) - 'a';
            if(temp.childs[c] == null)
                temp.childs[c] = new TrieNode();
            temp = temp.childs[c];
        }
        temp.isLeaf = true;
    }
    private boolean search(String word){
        int len = word.length();
        TrieNode temp = root;
        for(int i = 0; i < len; i++){
            int c = word.charAt(i) - 'a';
            if(temp.childs[c] == null) return false;
            temp = temp.childs[c];
        }
        return temp.isLeaf;
    }
    private boolean hasPrefix(String word){
        int len = word.length();
        TrieNode temp = root;
        for(int i = 0; i < len; i++){
            int c = word.charAt(i) - 'a';
            if(temp.childs[c] == null) return false;
            temp = temp.childs[c];
        }
        return true;
    }
}