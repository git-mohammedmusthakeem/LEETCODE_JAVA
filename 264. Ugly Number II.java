class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i = 1; i <= n; i++){
            dp[i] = Math.min(factor2, Math.min(factor3, factor5));
            if(dp[i] == factor2) factor2 = dp[++index2] * 2;
            if(dp[i] == factor3) factor3 = dp[++index3] * 3;
            if(dp[i] == factor5) factor5 = dp[++index5] * 5;
        }
        return dp[n - 1];
    }
}