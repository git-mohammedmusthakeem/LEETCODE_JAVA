class Solution {
      public int[] asteroidCollision(int[] asteroids) {
          Stack<Integer> stack = new Stack<>();
          LABEL:
          for(int a : asteroids){
              if(stack.isEmpty()){
                  stack.push(a);
              }else{
                  if((stack.peek() * a > 0) || (stack.peek() < 0 && a > 0)){
                      stack.push(a);
                  }else{
                      while(!stack.isEmpty() && stack.peek() * a < 0 && Math.abs(stack.peek()) <= Math.abs(a)){
                          if(Math.abs(stack.peek()) == Math.abs(a)){
                              stack.pop();
                              continue LABEL;
                          }else{
                              stack.pop();
                          }
                      }
                      if(stack.isEmpty() || stack.peek() * a > 0 || (stack.peek() * a < 0 && Math.abs(stack.peek()) < Math.abs(a))) stack.push(a);
                  }
              }
          }
          int[] result = new int[stack.size()];
          int count = 0, size = stack.size() - 1;
          while(!stack.isEmpty()){
              result[size--] = stack.pop();
          }
          return result;
      }
  }