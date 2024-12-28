class Solution {
    public void gameOfLife(int[][] board) {
        int height = board.length, width = board[0].length;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                int cur = board[i][j];
                int temp = checkNeighbour(board, i, j, height, width);
                if(cur == 1 && temp < 2) board[i][j] = 6;
                else if(cur == 0 && temp == 3) board[i][j] = 9;
                else if(cur == 1 && temp > 3) board[i][j] = 6;
            }
        }
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(board[i][j] == 6) board[i][j] = 0;
                else if(board[i][j] == 9) board[i][j] = 1;
            }
        }
    }
    private int checkNeighbour(int[][] board, int row, int col, int height, int width){
        int count = 0;
        if(row + 1 < height){
            if(board[row + 1][col] == 1 || board[row + 1][col] == 6) count++;
            if(col - 1 >= 0 && (board[row + 1][col - 1] == 1 || board[row + 1][col - 1] == 6)) count ++;
            if(col + 1 < width && (board[row + 1][col + 1] == 1 || board[row + 1][col + 1] == 6)) count ++;
        }
        if(row - 1 >= 0){
            if(board[row - 1][col] == 1 || board[row - 1][col] == 6) count++;
            if(col - 1 >= 0 && (board[row - 1][col - 1] == 1 || board[row - 1][col - 1] == 6)) count ++;
            if(col + 1 < width && (board[row - 1][col + 1] == 1 || board[row - 1][col + 1] == 6)) count ++;
        }
        if(col + 1 < width && (board[row][col + 1] == 1 || board[row][col + 1] == 6)) count++;
        if(col - 1 >= 0 && (board[row][col - 1] == 1 || board[row][col - 1] == 6)) count++;
        return count;
    }
}