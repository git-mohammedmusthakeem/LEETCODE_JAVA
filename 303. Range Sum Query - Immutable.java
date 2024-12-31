class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i <= nums.length; i++)
            sum[i] = nums[i - 1] + sum[i - 1];
    }
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}