class Solution {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int height = board.length, width = board[0].length;
        for(int i = 0; i < height; i++){
            if(board[i][0] == 'O') fill(board, i, 0);
            if(board[i][width - 1] == 'O') fill(board, i, width - 1);
        }
        for(int i = 0; i < width; i++){
            if(board[0][i] == 'O') fill(board, 0, i);
            if(board[height - 1][i] == 'O') fill(board, height - 1, i);
        }
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'Z') board[i][j] = 'O';
            }
        }
    }
    private void fill(char[][] board, int row, int col){
        board[row][col] = 'Z';
        int tempRow = 0, tempCol = 0;
        int height = board.length, width = board[0].length;
        for(int i = 0; i < 4; i++){
            tempRow = row + dir[i][0];
            tempCol = col + dir[i][1];
            if(tempRow >= 0 && tempRow < height && tempCol >= 0 && tempCol < width && board[tempRow][tempCol] == 'O')
                fill(board, tempRow, tempCol);
        }
    }
}