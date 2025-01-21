class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> map = new HashMap<>();
            for(char c : p.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int pLen = p.length(), sLen = s.length();
            List<Integer> res = new ArrayList<>();
            if(sLen < pLen) return res;
            Map<Character, Integer> temp = new HashMap<>();
            for(int i = 0; i < pLen; i++){
                char c = s.charAt(i);
                temp.put(c, temp.getOrDefault(c, 0) + 1);
            }
            for(int i = pLen; i <= sLen; i++){
                if(check(temp, map)) res.add(i - pLen);
                // Remove the first character
                char first = s.charAt(i - pLen);
                Integer count = temp.get(first);
                if(count == 1) temp.remove(first);
                else if(count != null) temp.put(first, count - 1);
                if(i < sLen){
                    char c = s.charAt(i);
                    temp.put(c, temp.getOrDefault(c, 0) + 1);
                }
            }
            return res;
        }
        private boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2){
            for(Map.Entry<Character, Integer> entry : map1.entrySet()){
                if(!map2.containsKey(entry.getKey())) return false;
                if(!map2.get(entry.getKey()).equals(entry.getValue())) return false;
            }
            return true;
        }
    }