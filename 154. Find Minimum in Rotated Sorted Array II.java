class Solution {
    public int findMin(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        return findMin(nums, low, high);
    }
    private int findMin(int[] nums, int low, int high){
        int mid = (low + high) / 2;
        if(low + 1 >= high) return Math.min(nums[low], nums[high]);
        if(nums[mid] == nums[high])		
            return findMin(nums, low, high-1);
        else if(nums[mid] >= nums[low] && nums[mid] > nums[high])
            return findMin(nums, mid, high);	
        else
            return findMin(nums, low, mid);	
    }
}