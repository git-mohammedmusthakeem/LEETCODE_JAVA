class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if(len == 1) return;
        for(int i = 1; i < len; i ++){
            if((i % 2 != 0 && nums[i - 1] >= nums[i]) || (i % 2 == 0 && nums[i - 1] <= nums[i])){
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }
}