private static int paintFence(int n, int k){
		int[] dp = new int[n + 1];
		dp[0] = 0; dp[1] = k;
		for(int i = 2; i <= n; i++){
			dp[i] = dp[i - 1] * k - dp[i - 2];
		}
		return dp[n];
	}