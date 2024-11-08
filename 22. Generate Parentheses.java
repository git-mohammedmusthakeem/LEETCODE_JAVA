class Solution {
		private List<String> result;
		public List<String> generateParenthesis(int n) {
			this.result = new ArrayList<>();
			if(n <= 0) return result;
			dfs("", n, n);
			return result;
		}
		private void dfs(String cur, int left, int right){
			if(left == 0 && right == 0) result.add(new String(cur));
			else{
				if(left > 0) dfs(cur + "(", left - 1, right);
				if(right > left) dfs(cur + ")", left, right - 1);
			}
		}
	}