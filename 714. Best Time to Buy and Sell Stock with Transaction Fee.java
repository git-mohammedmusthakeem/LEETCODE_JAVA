class Solution {
		public int maxProfit(int[] prices, int fee) {
			if(prices == null || prices.length <= 1) return 0;
			int len = prices.length;
			int[] buys = new int[len + 1];
			int[] sells = new int[len + 1];
			buys[1] = -prices[0];
			for(int i = 2; i <= len; i++){
				buys[i] = Math.max(buys[i - 1], sells[i - 1] - prices[i - 1]);
				sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i - 1] - fee);
			}
			return sells[len];
		}
	}