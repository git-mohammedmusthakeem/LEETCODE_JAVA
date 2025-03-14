class Solution {
		public int minCostClimbingStairs(int[] cost) {
			int n = cost.length;
			int[] dp = new int[n + 1];
			dp[0] = cost[0];
			dp[1] = cost[1];
			for(int i = 2; i <= n; i++){
				int cur = i == n ? 0: cost[i];
				dp[i] = cur + Math.min(dp[i - 1], dp[i - 2]);
			}
			return dp[n];
		}
	}