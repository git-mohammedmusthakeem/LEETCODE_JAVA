class Solution {
        public int findNumberOfLIS(int[] nums) {
            int len = nums.length;
            if(len == 0) return 0;
            int[] dp = new int[len];
            int[] count = new int[len];
            Arrays.fill(dp, 1);
            Arrays.fill(count, 1);
            int max = 1;
            for(int i = 1; i < len; i++){
                for(int j = i - 1; j >= 0; j--){
                    if(nums[i] > nums[j] && dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(nums[i] > nums[j] && dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
                max = Math.max(max, dp[i]);
            }
            int res = 0;
            for(int i = 0; i < len; i++){
                if(dp[i] == max){
                    res += count[i];
                }
            }
            return res;
        }
    }