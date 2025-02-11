class Solution {
        private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        public int findPaths(int m, int n, int N, int i, int j) {
            int[][][] dp = new int[N + 1][m][n];
            for(int k = 1; k <= N; k++){
                for(int r = 0; r < m; r++){
                    for(int c = 0; c < n; c++){
                        // (r, c) means the current position of a node.
                        int tempRow = 0, tempCol = 0;
                        for(int d = 0; d < 4; d++){
                            // (tempRow, tempCol) means the next posible position
                            tempRow = r + dir[d][0];
                            tempCol = c + dir[d][1];
                            if(tempRow < 0 || tempRow >= m || tempCol < 0 || tempCol >= n){
                                // if next position is out of boundary, current index add 1.
                                dp[k][r][c] += 1;
                            }else{
                                // if next position is within the boundary, we add that ways to current one.
                                dp[k][r][c] = (dp[k][r][c] + dp[k - 1][tempRow][tempCol]) % 1000000007;
                            }
                        }
                    }
                }
            }
            return dp[N][i][j];
        }
    }