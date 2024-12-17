class Solution {
    public int calculate(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result = 0;
        int len = arr.length;
        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            if(Character.isDigit(c)){
                int num = c - '0';
                while(i + 1 < len && Character.isDigit(arr[i + 1]))
                    num = num * 10 + (arr[++i] - '0');
                result += num * sign;
            }else if(c == '+'){
                sign = 1;
            }else if(c == '-'){
                sign = -1;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(c == ')'){
                sign = stack.pop();
                result = stack.pop() + sign * result;
            }
        }
        return result;
    }
}