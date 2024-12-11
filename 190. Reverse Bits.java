public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int low = 1;
        int high = 1 << 31;
        int result = 0;
        for(int i = 16; i >= 1; i--){
            int right = n & low;
            int left = n & high;
            left >>= i * 2 - 1;
            result += left;
            right <<= i * 2 - 1;
            result += right;
            low <<= 1;
            right >>= 1;
        }
        return result;
    }
}