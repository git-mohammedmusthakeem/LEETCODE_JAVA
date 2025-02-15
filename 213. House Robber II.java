class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int len = nums.length;
        if(1 == len) return nums[0];
        int result = 0;
        int[] dp = new int[len + 1];
        for(int i = 1; i < len; i++){
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + (i >= 2 ? dp[i - 2] : 0));
        }
        int[] dp1 = new int[len + 1];
        for(int i = 2; i <= len; i++){
            dp1[i] = Math.max(dp1[i - 1], nums[i - 1] + dp1[i - 2]);
        }
        return Math.max(dp[len - 1], dp1[len]);
    }
}