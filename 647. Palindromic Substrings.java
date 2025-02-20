class Solution {
      private char[] arr;
      public int countSubstrings(String s) {
          arr = s.toCharArray();
          int sum = 0;
          for(int i = 0; i < arr.length; i++){
              sum += expand(i, i);
              sum += expand(i, i + 1);
          }
          return sum;
      }
      private int expand(int i, int j){
          int res = 0;
          while(i >= 0 && j < arr.length && arr[i--] == arr[j++]){
              res++;
          }
          return res;
      }
  }