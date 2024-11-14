class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        char[][] map = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = '.';
            }
        }
        backtrace(result, map, 0, n);
        return result;
    }
    private void backtrace(List<List<String>> result, char[][] map, int i, int n){
        if(i == n){
            List<String> res = new LinkedList<>();
            for(int p = 0; p < n; p++)
                res.add(new String(map[p]));
            result.add(res);
        }else{
            for(int j = 0; j < n; j++){
                if(check(map, i, j)){
                    map[i][j] = 'Q';
                    backtrace(result, map, i + 1, n);
                    map[i][j] = '.';
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