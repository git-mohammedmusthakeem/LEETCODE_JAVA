class Solution {
    public int titleToNumber(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Character c = 'Z';
        for(int i = 26; i > 0; i--){
            map.put(c, i);
            c--;
        }
        int count = 0;
        if(s.length() == 0) return count;
        for(int i = 0; i < s.length(); i++){
            count = map.get(s.charAt(i)) + count * 26;
        }
        return count;
    }
}