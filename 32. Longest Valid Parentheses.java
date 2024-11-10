class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int result = 0;
        int[] dp = new int[len + 1];
        char[] arr = s.toCharArray();
        for(int i = 1; i < arr.length; i++){
            char c = arr[i];
            if(c == ')'){
                if(arr[i - 1] == '('){
                    dp[i + 1] = dp[i - 1] + 2;
                    result = Math.max(result, dp[i + 1]);
                }
                else if(arr[i - 1] == ')'){
                    if(i - 1 - dp[i] >=0 && arr[i - 1 - dp[i]] == '('){
                        dp[i + 1] = dp[i] + 2 + ((i - 1 - dp[i] >= 0) ? dp[i - 1 - dp[i]] : 0);
                        result = Math.max(result, dp[i + 1]);
                    }
                }
            }
        }
        return result;
    }
}