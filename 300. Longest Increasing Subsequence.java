class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len + 1];
        for(int i = 1; i <= len; i++) dp[i] = 1;
        int result = 1;
        for(int i = 2; i <= len; i++){
            int num = nums[i - 1];
            for(int j = i - 1; j >= 1; j--){
                if(num > nums[j - 1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}