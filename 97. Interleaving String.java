class Solution {
      public boolean isInterleave(String s1, String s2, String s3) {
          char[] s1Arr = s1.toCharArray();
          char[] s2Arr = s2.toCharArray();
          char[] s3Arr = s3.toCharArray();
          if(s1Arr.length + s2Arr.length != s3Arr.length) return false;
          boolean[][] dp = new boolean[s1Arr.length + 1][s2Arr.length + 1];
          dp[0][0] = true;
          for(int i = 1; i <= s1Arr.length; i++)
              dp[i][0] = dp[i - 1][0] && s1Arr[i - 1] == s3Arr[i - 1];
          for(int i = 1; i <= s2Arr.length; i++)
              dp[0][i] = dp[0][i - 1] && s2Arr[i - 1] == s3Arr[i - 1];
          for(int i = 1; i <= s1Arr.length; i++){
              for(int j = 1; j <= s2Arr.length; j++){
                  if(s1Arr[i - 1] == s3Arr[i + j - 1]){
                      dp[i][j] = dp[i - 1][j];
                  }
                  if(s2Arr[j - 1] == s3Arr[i + j - 1]){
                      dp[i][j] |= dp[i][j - 1];
                  }
              }
          }
          return dp[s1Arr.length][s2Arr.length];
      }
  }