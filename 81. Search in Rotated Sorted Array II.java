class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        return -1 != binarySearch(nums, target, 0, len - 1);
    }
    private int binarySearch(int[] nums, int target, int low, int high){
        if(low > high) return -1;
        int mid = low + (high - low) / 2;
        int midVal = nums[mid], lowVal = nums[low], highVal = nums[high];
        if(midVal == target) return mid;
        if(midVal == lowVal)
            return binarySearch(nums, target, low + 1, high);
        else if(midVal > lowVal){ //left is sorted
            if(target < midVal && target >= lowVal)
                return binarySearch(nums, target, low, mid - 1);
            else
                return binarySearch(nums, target, mid + 1, high);
        }else{
            if(target > midVal && target <= highVal)
                return binarySearch(nums, target, mid + 1, high);
            else
                return binarySearch(nums, target, low, mid - 1);
        }
    }
}