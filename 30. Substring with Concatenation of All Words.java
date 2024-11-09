class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || words == null || words.length == 0) return result;
        Map<String, Integer> compare = new HashMap<>();
        int wordLen = words[0].length();
        int wordNum = words.length;
        for(String ss : words){
            compare.put(ss, compare.containsKey(ss)?(compare.get(ss) + 1):1);
        }
        int slow = 0; int fast = 0;int start = 0;
        int len = s.length();
        for(; slow <= len - wordLen * wordNum; slow++){
            start = slow;
            fast = 1;
            Map<String, Integer> temp = new HashMap<>();
            for(; start + wordLen <= len; fast++ ){
                String sub = s.substring(start, wordLen + start);
                if(!compare.containsKey(sub)){
                    break;
                }
                else{
                    temp.put(sub, temp.containsKey(sub)?(temp.get(sub) + 1):1);
                    if(temp.equals(compare)){
                        result.add(slow);
                        break;
                    }
                    start += wordLen;
                }
            }
        }
        return result;
    }
}
