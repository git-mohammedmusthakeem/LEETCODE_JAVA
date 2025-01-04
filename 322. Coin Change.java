class Solution {
        public int coinChange(int[] coins, int amount) {
            int len = coins.length;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE >> 1);
            dp[0] = 0;
            for(int coin : coins){
                if(coin <= amount)
                    dp[coin] = 1;
            }
            for(int i = 1; i <= amount; i++){
                if(dp[i] == 1) continue;
                for(int coin : coins){
                    dp[i] = Math.min(i - coin >= 0 ? dp[i - coin] + 1: Integer.MAX_VALUE >> 1, dp[i]);
                }
            }
            return dp[amount] == Integer.MAX_VALUE >> 1 ? -1: dp[amount];
        }
    }