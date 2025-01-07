class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if(s.length() <= k) return s.length();
            int start = 0, end = 0;
            Map<Character, Integer> map = new HashMap<>();
            char[] arr = s.toCharArray();
            int max = 0;
            while(end < s.length()){
                if(map.containsKey(arr[end]) || map.size() < k){
                    map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
                    max = Math.max(max, end - start + 1);
                }else{  // current we need to remove
                    map.put(arr[end], 1);
                    while(map.size() > k){
                        char c = arr[start++];
                        int count = map.get(c);
                        if(count == 1){
                            map.remove(c);
                        }else{
                            map.put(c, count - 1);
                        }
                    }
                }
                end++;
            }
            return max;
        }
    }