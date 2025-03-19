class Solution {
      private int index = 0;
      private char[] arr;
      public int calculate(String s) {
          this.arr = s.toCharArray();
          return parse();
      }
      private int parse(){
          char operator = '+';
          int sum = 0;
          Stack<Integer> stack = new Stack<>();
          while(index < arr.length){
              char c = arr[index];
              if(c == '('){
                  index++;
                  addToStack(stack, operator, parse());
              }else if(Character.isDigit(c)){
                  int temp = c - '0';
                  index++;
                  while(index < arr.length && Character.isDigit(arr[index])){
                      temp = temp * 10 + arr[index++] - '0';
                  }
                  index--;
                  addToStack(stack, operator, temp);
              }else if(c == '+' || c == '-' || c == '*' || c == '/'){
                  System.out.println(c);
                  operator = c;
              }else if(c == ')'){
                  while(!stack.isEmpty()) sum += stack.pop();
                  return sum;
              }
              index++;
          }
          while(!stack.isEmpty()) sum += stack.pop();
          return sum;
      }
      private void addToStack(Stack<Integer> stack, char operator, int val){
          if(operator == '+') stack.push(val);
          else if(operator == '-') stack.push(-val);
          else if(operator == '*') stack.push(val * stack.pop());
          else if(operator == '/'){
              stack.push(stack.pop() / val);
          }
      }
  }