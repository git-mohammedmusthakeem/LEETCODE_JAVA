class Solution {
    public boolean isPowerOfFour(int num) {
        if(num < 0) return false;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((num & 1) != 0){
                if(++count > 1) return false;
                if(i % 2 != 0){
                    return false;
                }
            }
            num >>>= 1;
        }
        return count == 1;
    }
}