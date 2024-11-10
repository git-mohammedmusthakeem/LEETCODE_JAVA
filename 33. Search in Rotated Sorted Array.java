class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0; int high = nums.length - 1;
        return binarySearch(low, high, nums, target);
    }
    private static int binarySearch(int low, int high, int[] nums, int target){
        if(low > high)
            return -1;
        int mid = low + (high - low) / 2;
        int midVal = nums[mid];
        int lowVal = nums[low];
        int highVal = nums[high];
        if(midVal == target) return mid;
        if(midVal == lowVal){
            if(target == highVal)
                return high;
            else return -1;
        }else if(midVal > lowVal){    //left is in order
            if(target < midVal && target >= lowVal)
                return binarySearch(low, mid, nums, target);
            if(target < lowVal || target > midVal)
                return binarySearch(mid + 1, high, nums, target);
        }else{  //right is in order
            if(target > midVal && target <= highVal)
                return binarySearch(mid, high, nums, target);
            if(target > highVal || target < midVal)
                return binarySearch(low, mid - 1, nums, target);
        }
        return -1;
    }
}