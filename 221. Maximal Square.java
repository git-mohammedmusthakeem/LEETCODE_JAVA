class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int height = matrix.length, width = matrix[0].length;
        int max = 0;
        int[][] dp = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(matrix[i][j] == '1'){
                    if(i > 0 && j > 0){
                        if(dp[i - 1][j] == 0 || dp[i][j - 1] == 0 || dp[i - 1][j - 1] == 0)
                            dp[i][j] = 1;
                        else
                            dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }else dp[i][j] = 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}