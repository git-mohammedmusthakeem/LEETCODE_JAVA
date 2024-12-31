class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int height = matrix.length, width = matrix[0].length;
        dp = new int[height][width + 1];
        for(int i = 0; i < height; i++)
            dp[i][0] = 0;
        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++)
                dp[i][j + 1] = dp[i][j] + matrix[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(; row1 <= row2; row1++)
            sum += this.dp[row1][col2 + 1] - dp[row1][col1];
        return sum;
    }
}