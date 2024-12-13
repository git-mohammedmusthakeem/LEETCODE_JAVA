class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        return isHappy(n, s);
    }
    private boolean isHappy(int n, Set<Integer> s){
        if(s.contains(n)) return false;
        else{
            s.add(n);
            int cur = 0;
            int remain = 0;
            int sum = 0;
            while(n != 0){
                remain = n % 10;
                n /= 10;
                sum += Math.pow(remain, 2);
            }
            if(sum == 1) return true;
            else{
                return isHappy(sum, s);
            }
        }
    }
}