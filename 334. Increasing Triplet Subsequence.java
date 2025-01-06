class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        int len = nums.length;
        int[] in = new int[len];
        int[] de = new int[len];
        de[0] = nums[0];
        for(int i = 1; i < len; i++){
            de[i] = Math.min(de[i - 1], nums[i]);
        }
        in[len - 1] = nums[len - 1];
        for(int i = len - 2; i >= 0; i--){
            in[i] = Math.max(in[i + 1], nums[i]);
        }
        for(int i = 0; i < len; i++)
            if(nums[i] > de[i] && nums[i] < in[i]) return true;
        return false;
    }
}