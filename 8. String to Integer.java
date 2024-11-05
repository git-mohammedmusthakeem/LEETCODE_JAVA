class Solution {
    public int myAtoi(String str) {
        Map<Character,Integer> m = new HashMap<>();
        String s = "0123456789";
        for(int i = 0; i < 10; i++){
            m.put(s.charAt(i), i);
        }
        int len = str.length();
        if(len == 0) return 0;
        Double result = 0D;
        Integer positive = 1;
        int i = 0;
        while(str.charAt(i) == ' '){
            i++;
            if(i == len){
            	return 0;
            }
        }
        Integer temp = m.get(str.charAt(i));
        if(null == temp && str.charAt(i) != '-' && str.charAt(i) != '+'){
            return 0;
        }else if(str.charAt(i) == '-'){
            positive = -1;
            i++;
        }else if(str.charAt(i) == '+'){
            i++;
        }
        while(i <len && (temp = m.get(str.charAt(i))) != null){
            result = result * 10 + temp;
            i++;
        }
        result = positive * result;
        if(result > Integer.MAX_VALUE)  return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE)  return Integer.MIN_VALUE;
        return result.intValue();
    }
}
```