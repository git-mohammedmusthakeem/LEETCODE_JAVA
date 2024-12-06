class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int diff = 0;
        for(int i = 1; i < nums.length; i++)
            diff = Math.max(diff, nums[i] - nums[i - 1]);
        return diff;
    }
}