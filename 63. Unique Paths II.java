class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length, width = obstacleGrid[0].length;
        int[][] dp = new int[height][width];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 0; i < height && obstacleGrid[i][0] != 1; i++)
            dp[i][0] = 1;
        for(int i = 0; i < width && obstacleGrid[0][i] != 1; i++)
            dp[0][i] = 1;
        for(int i = 1; i < height; i++){
            for(int j = 1; j < width; j++){
                if(obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[height - 1][width - 1];
    }
}