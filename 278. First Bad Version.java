public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 0 || n == 1) return n;
        int low = 1, high = n;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(isBadVersion(mid))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}