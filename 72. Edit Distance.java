class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len1; i++)
            dp[i + 1][0] = i + 1;
        for(int i = 0; i < len2; i++)
            dp[0][i + 1] = i + 1;
        for(int i = 1; i <= len1; i++){
            char c1 = word1.charAt(i - 1);
            for(int j = 1; j <= len2; j++){
                char c2 = word2.charAt(j - 1);
                if(c1 == c2){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[len1][len2];
    }
}