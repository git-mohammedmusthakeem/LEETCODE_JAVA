class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int res = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                res = Math.min(res, dp[i - j * j] + 1);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}