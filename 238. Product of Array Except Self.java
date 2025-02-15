class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for(int i = 0, temp = 1; i < len; i++){
            result[i] = temp;
            temp *= nums[i];
        }
        for(int i = len - 1, temp = 1; i >= 0; i--){
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}