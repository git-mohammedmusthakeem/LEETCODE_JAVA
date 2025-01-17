class Solution {
        public int splitArray(int[] nums, int m) {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for(int i = 1; i < nums.length; i++) sum[i] = sum[i - 1] + nums[i];
            int[][] dp = new int[m + 1][nums.length];
            for(int[] d: dp) Arrays.fill(d, Integer.MAX_VALUE);
            for(int i = 0; i < nums.length; i++){
                dp[1][i] = sum[i];
            }
            for(int i = 2; i <= m; i++){
                for(int j = i - 1; j < nums.length; j++){
                    for(int k = 0; k < j; k++){
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], sum[j] - sum[k]));
                    }                
                }
            }
            return dp[m][nums.length - 1];
        }
    }