class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = ~0;
        while(m != n){
            mask <<= 1;
            m &= mask;
            n &= mask;
        }
        return m;
    }
}