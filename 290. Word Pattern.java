class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        char[] charArr = pattern.toCharArray();
        if(arr.length != charArr.length) return false;
        Map<String, Character> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i]) && !map.containsValue(charArr[i])){
                map.put(arr[i], charArr[i]);
            }else if(!map.containsKey(arr[i]) && map.containsValue(charArr[i])){
                return false;
            }else{
                if(charArr[i] != map.get(arr[i]))
                    return false;
            }
        }
        return true;
    }
}