public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i <= 31; i++){
            count = ((n & 1) == 1)? count + 1: count;
            n >>>= 1;
        }
        return count;
    }
}