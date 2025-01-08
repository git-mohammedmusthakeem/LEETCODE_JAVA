class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int max = 0;
            for(int j = 1; j <= i / 2; j++){
                max = Math.max(max, Math.max(j * (i - j), dp[j] * dp[i - j]));
                max = Math.max(max, Math.max(j * dp[i - j], dp[j] * (i - j)));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}