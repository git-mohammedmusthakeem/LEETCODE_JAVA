class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        if(strs == null || strs.length == 0) return result;
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] t = strs[i].toCharArray();
            Arrays.sort(t);
            String temp = new String(t);
            if(!map.containsKey(temp))
                map.put(temp, new LinkedList<String>());
            map.get(temp).add(strs[i]);
        }
        result.addAll(map.values());
        return result;
    }
}