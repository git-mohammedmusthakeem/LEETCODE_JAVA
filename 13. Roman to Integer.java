class Solution {
	    public int romanToInt(String s) {
	        int result = 0;
	        String[] roman = {"M", "CM","D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		    int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	        Map<String, Integer> m = new HashMap<>();
	        for(int i = 0; i < n.length; i++){
	            m.put(roman[i], n[i]);
	        }
	        int len = s.length();
	        int i = 0;
	        while(i < len){
	            Integer temp = null;
	            if(i+2 <= len){
	                temp = m.get(s.substring(i, i+2));
	                if(null != temp){
	                    result += temp;
	                    i += 2;
	                    continue;
	                }else{
	                    result += m.get(s.substring(i, i+1));
	                    i++;
	                    continue;
	                }
	            }else{
	                result += m.get(s.substring(i, i+1));
	                i ++;
	                continue;
	            }
	        }
	        return result;
	    }
	}