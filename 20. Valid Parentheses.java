class Solution {
	    public boolean isValid(String s) {
	        Stack<Character> stack = new Stack<>();
	        Map<Character, Character> m = new HashMap<>();
	        m.put(')', '(');
	        m.put(']', '[');
	        m.put('}', '{');
	        int len = s.length();
	        for(int i = 0; i < len; i++){
	            char c = s.charAt(i);
	            if(m.values().contains(c)){
	                stack.push(c);                
	            }else{
	                if(!m.keySet().contains(c)){
	                    return false;
	                }else{
	                    if(stack.size() != 0){
	                        Character temp = stack.pop();
	                        if(temp == null || temp != m.get(c)) return false;
	                    }else   return false;
	                }
	            }
	        }
	        if(stack.size() != 0) return false;
	        return true;
	     }
	}