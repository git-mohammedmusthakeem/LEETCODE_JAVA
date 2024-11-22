class Solution {
    public int numDecodings(String s) {
        if(s == null) return 1;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c > '0' && c <= '9') dp[i + 1] += dp[i];
            if(i > 0 && c >= '0' && c <= '6' && s.charAt(i - 1) == '2') dp[i + 1] += dp[i - 1];
            if(i > 0 && s.charAt(i - 1) == '1') dp[i + 1] += dp[i - 1];
        }
        return dp[len];
    }
}