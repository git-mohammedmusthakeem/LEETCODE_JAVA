class Solution {
        private int[][][] dp;
        public int cherryPickup(int[][] grid) {
            int height = grid.length, width = grid[0].length;
            dp = new int[height][width][height];
            for(int i = 0; i < height; i++)
                for(int j = 0; j < width; j++)
                    Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            return Math.max(dp(grid, height - 1, width - 1, height - 1), 0);
        }
        private int dp(int[][] grid, int x1, int y1, int x2){
            int y2 = x1 + y1 - x2;
            if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0){
                return -1;
            }
            if(x1 == 0 && y1 == 0 && x2 == 0){
                dp[0][0][0] = grid[0][0];
                return dp[0][0][0];
            }
            if(dp[x1][y1][x2] != Integer.MIN_VALUE) return dp[x1][y1][x2];
            if(grid[x1][y1] == -1 || grid[x2][y2] == -1) return -1;
            dp[x1][y1][x2] = Math.max(Math.max(dp(grid, x1 - 1, y1, x2), dp(grid, x1, y1 - 1, x2)), 
                                       Math.max(dp(grid, x1, y1 - 1, x2 - 1), dp(grid, x1 - 1, y1, x2 - 1)));
            if(dp[x1][y1][x2] >= 0){
                int g1 = grid[x1][y1], g2 = grid[x2][y2];
                if(g1 >= 0) dp[x1][y1][x2] += g1;
                if(g2 >= 0) dp[x1][y1][x2] += g2;
                if(g1 == g2 && g1 == 1 && x1 == x2 && y1 == y2)
                    dp[x1][y1][x2]--;
            }
            return dp[x1][y1][x2];
        }
    }