class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        Stack<Integer> inStack = new Stack<>();
        Stack<StringBuilder> sStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                count = count * 10 + (c - '0');
            }else if(c == '['){
                inStack.push(count);
                sStack.push(sb);
                sb = new StringBuilder();
                count = 0;
            }else if(c == ']'){
                StringBuilder temp = sb;
                sb = sStack.pop();
                for(int i = inStack.pop(); i >0; i--)
                    sb.append(temp);
            }else
                sb.append(c);
        }
        return sb.toString();
    }
}