class Solution {
    public int calculate(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        char opt = ' ';
        for(int i = 0; i < len; i++){
            char c = arr[i];
            if(Character.isDigit(c)){
                int num = c - '0';
                while(i + 1 < len && Character.isDigit(arr[i + 1])){
                    num = num * 10 + arr[++i] - '0';
                }
                if(opt == '*'){
                    int pre = stack.pop();
                    stack.push(pre * num);
                }else if(opt == '/'){
                    int pre = stack.pop();
                    stack.push(pre / num);
                }else if(opt == '-'){
                    stack.push(-1 * num);
                }else{
                    stack.push(num);
                }
            }else if(c == '+' ||c == '-' ||c == '*' || c == '/'){
                opt = c;
            }
        }
        int result = 0;
        for(Integer i : stack)
            result += i;
        return result;
    }
}