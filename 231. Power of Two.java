class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        int temp = 0;
        int count = 0;
        for(int i = 0; i < 31; i++){
            temp = n & 1;            
            if(temp == 1){
                count ++;
                if(count > 1) return false;
            }
            n >>= 1;            
        }
        return true;
    }
}