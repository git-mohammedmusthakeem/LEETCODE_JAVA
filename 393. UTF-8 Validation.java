class Solution {
      private int[] data;
      public boolean validUtf8(int[] data) {
          this.data = data;
          return valid(0);
      }
      private boolean valid(int index){
          if(index == data.length) return true;
          int cur = data[index];
          if((cur & (1 << 7)) == 0){
              return valid(index + 1);
          }else if((cur & (3 << 6)) == 0b10000000){
              return false;
          }else{
              int count = 0;
              int mask = 0b10000000;
              while((cur & mask) > 0){
                  count++;
                  mask >>= 1;
              }
              if(count > 4 || index + count > data.length) return false;
              for(int i = index + 1; i < index + count; i++){
                  if((data[i] & (3 << 6)) != 0b10000000) return false;
              }
              return valid(index + count);
          }
      }
  }