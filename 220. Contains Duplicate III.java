class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || t < 0 || k < 1) return false;
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            SortedSet<Long> sub = set.subSet((long)nums[i] - t, true, (long)nums[i] + t, true);
            if(!sub.isEmpty())
                return true;   
            if(i >= k)
                set.remove((long)nums[i - k]);
            set.add((long)nums[i]);
        }
        return false;
    }
}