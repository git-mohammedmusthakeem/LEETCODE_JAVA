class Solution {    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int height = grid.length;
        int width = grid[0].length;
        boolean[][] used = new boolean[height][width];
        int count = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == '1' && !used[i][j]){
                    count ++;
                    bfs(grid, used, i, j);
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, boolean[][] used, int row, int col){
        if(!(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1' && !used[row][col]))
            return;
        used[row][col] = true;
        for(int i = 0; i < 4; i++){
            bfs(grid, used, row + dir[i][0], col + dir[i][1]);
        }
    }
}