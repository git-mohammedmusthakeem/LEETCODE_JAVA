class Solution {
		private int amount;
		private int[] coins;
		private int res;
		public int change(int amount, int[] coins) {
			this.amount = amount;
			this.coins = coins;
			dfs(0, 0);
			return res;
		}
		private void dfs(int index, int sum){
			if(sum == amount) res++;
			else if(sum < amount){
				for(int i = index; i < coins.length; i++){
					dfs(i, sum + coins[i]);
				}
			}
		}
	}