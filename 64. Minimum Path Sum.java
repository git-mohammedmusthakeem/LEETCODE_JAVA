class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int height = grid.length, width = grid[0].length;
        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < height; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        for(int i = 1; i < width; i++)
            dp[0][i] = dp[0][i - 1] +grid[0][i];
        for(int i = 1; i < height; i++){
            for(int j = 1; j < width; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[height - 1][width - 1];
    }
}