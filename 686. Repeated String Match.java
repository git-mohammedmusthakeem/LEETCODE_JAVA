class Solution {
        private static final int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        private char[][] board;
        private int height, width;
        private Set<Integer> visited;
        private int[] click;
        public char[][] updateBoard(char[][] board, int[] click) {
            this.board = board;
            this.height = board.length;
            this.width = board[0].length;
            visited = new HashSet<>();
            this.click = click;
            click(click[0], click[1]);
            return this.board;
        }
        private void click(int x, int y){
            visited.add(x * width + y);
            if(board[x][y] == 'M'){
                if(x == click[0] && y == click[1])
                    board[x][y] = 'X';
                return;
            }else{
                int mimeNum = checkMimeNum(x, y);
                board[x][y] = mimeNum > 0 ? (char)('0' + mimeNum): 'B';
                if(mimeNum == 0){
                    int tx = 0, ty = 0;
                    for(int d = 0; d < 8; d++){
                        tx = x + dir[d][0];
                        ty = y + dir[d][1];
                        if(tx >= 0 && tx < height && ty >= 0 && ty < width && !visited.contains(tx * width + ty))
                            click(tx, ty);
                    }
                }
            }
        }
        private int checkMimeNum(int x, int y){
            int tx = 0, ty = 0;
            int count = 0;
            for(int d = 0; d < 8; d++){
                tx = x + dir[d][0];
                ty = y + dir[d][1];
                if(tx >= 0 && tx < height && ty >= 0 && ty < width && board[tx][ty] == 'M')
                    count++;
            }
            return count;
        }
    }