class Solution {
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int height = matrix.length, width = matrix[0].length;
        int res = 1;
        int[][] cache = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                res = Math.max(res, bfs(matrix, i, j, cache));
            }
        }
        return res;
    }
    private int bfs(int[][] matrix, int row, int col, int[][] cache){
        if(cache[row][col] != 0) return cache[row][col];
        int cur = matrix[row][col];
        int height = matrix.length, width = matrix[0].length;
        int max = 1;
        for(int d = 0; d < 4; d++){
            int tempRow = row + dir[d][0];
            int tempCol = col + dir[d][1];
            if(tempRow >= 0 && tempRow < height && tempCol >= 0 && tempCol < width && matrix[tempRow][tempCol] > cur){
                max = Math.max(max, bfs(matrix, tempRow, tempCol, cache) + 1);
            }
        }
        cache[row][col] = max;
        return cache[row][col];
    }
}