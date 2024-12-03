class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < tokens.length; i++){
            if(!isOper(tokens[i]))
                stack.push(Integer.parseInt(tokens[i]));
            else{
                Integer b = stack.pop();
                Integer a = stack.pop();
                result = operation(a, b, tokens[i]);
                stack.push(result);
            }
        }
        return result;
    }
    public static boolean isOper(String s){
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }
    private static int operation(Integer a, Integer b, String op){
        if(op.equals("+")) return a + b;
        else if(op.equals("-")) return a - b;
        else if(op.equals("*")) return a * b;
        else return a / b;
    }
}