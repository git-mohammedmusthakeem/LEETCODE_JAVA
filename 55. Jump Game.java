class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return true;
        int slow = 0, fast = 0, reach = 0;
        for(int i = 0; i < nums.length; i++){
            if(reach < i) return false;
            else if(reach >= nums.length - 1) return true;
            for(int j = slow; j <= fast; j++){
                reach = Math.max(reach, j + nums[j]);
            }
            slow = fast + 1;
            fast = reach;
        }
        return true;
    }
}