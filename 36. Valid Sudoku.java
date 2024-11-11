class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set1 =  null;
        Set<Character> set2 =  null;
        for(int i = 0; i < 9; i++){
            set1 = new HashSet<Character>();
            set2 = new HashSet<Character>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(set1.contains(board[i][j])) return false;
                    set1.add(board[i][j]);
                }
                if(board[j][i] != '.'){
                    if(set2.contains(board[j][i])) return false;
                    set2.add(board[j][i]);
                }
            }
        }
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                set1 = new HashSet<Character>();
                for(int p = i % 3; p < 3; p++){
                    for(int q  = j % 3; q < 3; q++){
                        if(board[i + p][j + q] != '.')
                            if(set1.contains(board[i + p][j + q])) return false;
                        set1.add(board[i + p][j + q]);
                    }
                }
            }
        }
        return true;
    }
}