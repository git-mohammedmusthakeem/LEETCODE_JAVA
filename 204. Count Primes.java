class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        if(n == 2) return 1;
        int count = 1;
        Set<Integer> set = new HashSet<>();
        set.add(2);
        for(int i = 3; i < n; i+=2){
            if(isPrime(i, set)) count++;
        }
        return count;
    }
    private boolean isPrime(int n, Set<Integer> set){
        for(Integer num : set){
            if(n % num == 0) return false;
        }
        set.add(n);
        return true;
    }
}