class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            Set<Character> set = new HashSet<>();
            for(int j = i; j < arr.length; j++){
                if(!set.contains(arr[j]))
                    set.add(arr[j]);
                else{
                    max = Math.max(max, set.size());
                    break;
                }
            }
            max = Math.max(set.size(), max);
        }
        return max;
    }
}
