class Solution {
    public boolean exist(char[][] board, String word) {
        if(null == board || board.length == 0 || word == null) return false;
        int height = board.length; int width = board[0].length;
        if(height * width < word.length()) return false;
        char c = word.charAt(0);
        boolean[][] used = new boolean[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(board[i][j] == c){
                    used[i][j] = true;
                    if(backtrace(board, i, j, 1, word, height, width, used))
                        return true;
                    used[i][j] = false;
                }
            }
        }
        return false;
    }
    public static boolean backtrace(char[][] board, int x, int y, int index, String word, int height, int width, boolean[][] used){
        if(index == word.length())
            return true;
        else{
            char c = word.charAt(index);
            List<Integer> option = valid(board, x, y, c, used);
            if(option.size() == 0) return false;
            else{
                boolean temp = false;
                for(Integer opt : option){
                    switch(opt){
                        case 0:
                            used[x - 1][y] = true;
                            temp |= backtrace(board, x - 1, y, index + 1, word, height, width, used);
                            used[x - 1][y] = false;
                            break;
                        case 1:
                            used[x][y - 1] = true;
                            temp |= backtrace(board, x, y - 1, index + 1, word, height, width, used);
                            used[x][y - 1] = false;
                            break;
                        case 2:
                            used[x + 1][y] = true;
                            temp |= backtrace(board, x + 1, y, index + 1, word, height, width, used);
                            used[x + 1][y] = false;
                            break;
                        case 3:
                            used[x][y + 1] = true;
                            temp |= backtrace(board, x, y + 1, index + 1, word, height, width, used);
                            used[x][y + 1] = false;
                            break;
                    }
                }
                return temp;
            }
        }
    }
    private static List<Integer> valid(char[][] board, int x, int y, char c, boolean[][] used){ // -1: invalid, 0: up, 1: left, 2: down, 3: right
        List<Integer> result = new ArrayList<>();
        if(x > 0) if(!used[x - 1][y] && board[x - 1][y] == c) result.add(0);
        if(y > 0) if(!used[x][y - 1] && board[x][y - 1] == c) result.add(1);
        if(x < board.length - 1) if(!used[x + 1][y] && board[x + 1][y] == c) result.add(2);
        if(y < board[0].length - 1) if(!used[x][y + 1] && board[x][y + 1] == c) result.add(3);
        return result;
    }
}