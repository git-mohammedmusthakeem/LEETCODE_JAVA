class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        int i = len - 2;
        for(; i >= 0; i--){
            if(nums[i] >= nums[i + 1]) continue;
            int min = Integer.MAX_VALUE, count = 0;
            for(int j = i + 1; j < len; j++){
                if(nums[j] > nums[i] && nums[j] < min){
                    count = j;
                    min = nums[j];
                }
            }
            swap(nums, count, i);
            break;
        }
        Arrays.sort(nums, i + 1, len);
    }
    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}