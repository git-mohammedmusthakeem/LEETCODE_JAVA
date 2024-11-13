class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1D;
        double half = myPow(x, n / 2);
        return n % 2 == 0 ? half * half: n > 0 ? x * half * half : (1 / x) * half * half;
    }
}