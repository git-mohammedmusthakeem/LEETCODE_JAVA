class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            int index = 0;
            while(index < bits.length){
                if(index == bits.length - 1) return true;
                if(bits[index] == 0) index++;
                else index += 2;
            }
            return false;
        }
    }