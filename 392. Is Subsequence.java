class Solution {
		public boolean isSubsequence(String s, String t) {
			int sLen = s.length(), tLen = t.length();
			boolean[][] dp = new boolean[tLen + 1][sLen + 1];
			for(int i = 0; i <= tLen; i++){
				dp[i][0] = true;
			}
			for(int i = 1; i <= tLen; i++){
				for(int j = 1; j <= sLen; j++){
					if(s.charAt(j - 1) == t.charAt(i - 1)){
						dp[i][j] = dp[i - 1][j - 1];
					}else{
						dp[i][j] |= dp[i - 1][j];
					}
				}
			}
			return dp[tLen][sLen];
		}
	}