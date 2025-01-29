class Solution {
		public int findTargetSumWays(int[] nums, int S) {
			int sum = 0;
			for(int num : nums)
				sum += num;
			if(sum < S || -sum > S) return 0;
			int offset = sum;
			int[][] dp = new int[nums.length + 1][sum * 2 + 1];
			dp[0][offset] = 1;
			for(int i = 1; i <= nums.length; i++){
				for(int j = 0; j < sum * 2 + 1; j++){
					dp[i][j] = (j - nums[i - 1] >= 0 ? dp[i - 1][j - nums[i - 1]]: 0)
						+ (j + nums[i - 1] < sum * 2 + 1 ? dp[i - 1][j + nums[i - 1]]: 0);
				}
			}
			return dp[nums.length][S + offset];
		}
	}