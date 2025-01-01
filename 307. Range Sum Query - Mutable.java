class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        this.sum = new int[nums.length];
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            count += nums[i];
            sum[i] = count;
        }
    }

    public void update(int i, int val) {
        int old = i > 0? (sum[i] - sum[i - 1]): sum[0];
        int diff = val - old;
        for(int j = i; j < sum.length; j++){
            sum[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return sum[j];
        else
            return sum[j] - sum[i - 1];
    }
}