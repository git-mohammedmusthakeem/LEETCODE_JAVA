class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        return helper(arr, 0, arr.length, k);
    }
    private static int helper(char[] arr, int start, int end, int k){
        if(end - start < k) return 0;
        int[] count = new int[26];
        for(int i = start; i < end; i++){
            count[arr[i]-'a']++;
        }
        for(int i = start; i < end; i++){
            if(count[arr[i] - 'a'] > 0 && count[arr[i] - 'a'] < k){
                return Math.max(helper(arr, start, i, k), helper(arr, i + 1, end, k));
            }
        }
        return end - start;
    }
}