class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int height = dungeon.length, width = dungeon[0].length;
            int[][] dp = new int[height][width];
            dp[height - 1][width - 1] = Math.max(1, -dungeon[height - 1][width - 1] + 1);
            for(int i = height - 2; i >= 0; i--)
                dp[i][width - 1] = Math.max(-dungeon[i][width - 1] + dp[i + 1][width - 1], 1);
            for(int i = width - 2; i >= 0; i--)
                dp[height - 1][i] = Math.max(1, -dungeon[height - 1][i] + dp[height - 1][i + 1]);
            for(int i = height - 2; i >= 0; i--){
                for(int j = width - 2; j >= 0; j--){
                    dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
                }
            }
            return dp[0][0];
        }
    }