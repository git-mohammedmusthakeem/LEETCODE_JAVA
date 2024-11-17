class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int low = 1, high = x, mid = 0;
        while(true){
            mid = low + (high - low) / 2;
            if(mid > x / mid)
                high = mid - 1;
            else{
                if((mid + 1) > (x / (mid + 1)))
                    return mid;
                else
                    low = mid + 1;
            }
        }
    }
}