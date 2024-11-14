class Solution {
    private int res = 0;
    public int totalNQueens(int n) {
        if(n == 0) return 0;
        char[][] map = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                map[i][j] = '.';
        }
        backtrace(map, 0, n);
        return this.res;
    }
    private void backtrace(char[][] map, int row, int n){
        if(row == n) res ++;
        else{
            for(int i = 0; i < n; i++){
                if(check(map, row, i)){
                    map[row][i] = 'Q';
                    backtrace(map, row + 1, n);
                    map[row][i] = '.';
                }
            }
        }
    }
    private boolean check(char[][] map, int row, int col){
        for(int i = 0; i < row; i++) if(map[i][col] == 'Q') return false;
        for(int i = 0; i < col; i++) if(map[row][i] == 'Q') return false;
        int i = row, j = col;
        while(--i >= 0 && --j >= 0) if(map[i][j] == 'Q') return false;
        while(--row >= 0 && ++col < map.length) if(map[row][col] == 'Q') return false;
        return true;
    }
}