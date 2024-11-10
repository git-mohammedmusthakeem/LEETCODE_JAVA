class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int res = binarySearch(nums, target, 0, nums.length - 1);
        if(res == -1) return new int[]{-1, -1};
        int low = res, high = res;
        while(low >= 0 && nums[low] == target){low --;}
        while(high < nums.length && nums[high] == target){high ++;}
        return new int[]{low + 1, high - 1};
    }
    private int binarySearch(int[] nums, int target, int low, int high){
        if(low > high || low < 0 || high >= nums.length) return -1;
        int mid = low + (high - low) / 2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target)
            return binarySearch(nums, target, low, mid - 1);
        else
            return binarySearch(nums, target, mid + 1, high);
    }
}