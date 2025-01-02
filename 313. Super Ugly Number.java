class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] index = new int[primes.length];
        int[] factor = Arrays.copyOf(primes, primes.length);
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                min = Math.min(min, factor[j]);
            }
            dp[i] = min;
            for(int j = 0; j < index.length; j++){
                if(factor[j] == min){
                    factor[j] = dp[++index[j]] * primes[j];
                }
            }
        }
        return dp[n - 1];
    }
}