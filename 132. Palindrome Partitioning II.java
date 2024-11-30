class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0 || s.length() == 1) return 0;
        int len = s.length();
        // 用于存储从第一个index到第二个index是否是回文的。
        boolean[][] dp = new boolean[len][len];
        int[] cut = new int[len];
        int min = 0;
        char[] arr = s.toCharArray();
        for(int end = 0; end < len; end++){
            min = end;
            for(int start = 0; start <= end; start++){
              // 当首字符和尾字符相同时， 此时我们通过(start + 1 > end - 1)证明当前指向的是某个字符本身，或者其中包含的字符是回文的(dp[start + 1][end - 1])
              // 这就说明从当前的start到end是回文的。
                if(arr[end] == arr[start] && (start + 1 > end - 1 || dp[start + 1][end - 1])){
                    dp[start][end] = true;
                    if(start == 0) min = 0;
                    // 鉴于start到end的字符串是回文的，所以最坏的可能性就是cut[start - 1]（前面的字符串需要分割的最小次数） + 1（为了分割当前的字符串）
                    else min = Math.min(min, cut[start - 1] + 1);
                }
            }
            cut[end] = min;
        }
        return cut[len - 1];
    }
}