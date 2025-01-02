class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[][] dp = new int[len + 2][len + 2];
        int[] arr = new int[len + 2];
        for(int i = 1; i < len + 1; i++){
            arr[i] = nums[i - 1];
            dp[i][i] = arr[i];
        }
        arr[0] = arr[len + 1] = 1;
        for(int dist = 1; dist <= len; dist++){
            for(int left = 1; left <= len - dist + 1; left++){
                int right = left + dist - 1;
                for(int mid = left; mid <= right; mid ++){
                    dp[left][right] = Math.max(dp[left][right], dp[left][mid - 1] + arr[left - 1] * arr[mid] * arr[right + 1] + dp[mid + 1 ][right]);
                }
            }
        }
        return dp[1][len];
    }
}