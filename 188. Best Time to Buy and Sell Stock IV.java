class Solution {
		public int maxProfit(int k, int[] prices) {
			if(k == 0 || prices == null || prices.length <= 1) return 0;
			int len = prices.length;
			if(k > len) return maxProfit(prices);
			int[][] buys = new int[len + 1][k + 1];
			int[][] sells = new int[len + 1][k + 1];
			for(int i = 2; i <= k; i++){
				for(int j = 0; j < i; j++){
					buys[j][i] = Integer.MIN_VALUE;
				}
			}
			int sum = 0;
			for(int i = 1; i <= k; i++){
				sum -= prices[i - 1];
				buys[i][i] = sum;
			}
			for(int i = 2; i <= len; i++){
				for(int j = 1; j <= k; j++){
					buys[i][j] = Math.max(buys[i - 1][j], sells[i - 1][j - 1] - prices[i - 1]);
					sells[i][j] = Math.max(sells[i - 1][j], buys[i - 1][j] + prices[i - 1]);
				}
			}        
			int profit = 0;
			for(int i = 0; i <= k; i++){
				profit = Math.max(profit, sells[len][i]);
			}
			return profit;
		}
		
		private int maxProfit(int[] prices) {
				int len = prices.length;
				int[] buys = new int[len + 1];
				int[] sells = new int[len + 1];
				buys[1] = -prices[0];
				for(int i = 2; i <= len; i++){
					buys[i] = Math.max(buys[i - 1], sells[i - 1] - prices[i - 1]);
					sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i - 1]);
				}
				return sells[len];
			}
	}