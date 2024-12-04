class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int mid = nums.length / 2;
        if(nums[mid] > nums[0]){
            for(int i = mid + 1; i < nums.length; i++)
                if(nums[i] < nums[i - 1]) return nums[i];
            return nums[0];
        }else{
            for(int i = 1; i <= mid; i++)
                if(nums[i] < nums[i - 1]) return nums[i];
            return nums[mid];
        }
    }
}