class Solution {
        public boolean canPartition(int[] nums) {
            int len = nums.length;
            int sum = 0;
            for(int num : nums)
                sum += num;
            if((sum & 1) == 1) return false;
            sum >>= 1;
            boolean[][] dp = new boolean[sum + 1][len + 1];
            dp[0][0] = true;
            for(int i = 1; i <= sum; i++){
                for(int j = 1; j <= len; j++){
                    dp[i][j] = dp[i][j - 1];
                    dp[i][j] |= i - nums[j - 1] >= 0 ? dp[i - nums[j - 1]][j - 1]: false;
                }
            }
            return dp[sum][len];
        }
    }