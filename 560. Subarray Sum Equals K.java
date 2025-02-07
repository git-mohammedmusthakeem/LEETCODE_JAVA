class Solution {
        public int subarraySum(int[] nums, int k) {
            if(nums == null || nums.length == 0) return 0;
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                sum[i] = sum[i - 1] + nums[i];
            }
            int res = 0;
            for(int i = 0; i < nums.length; i++){
                if(sum[i] == k) res++;
                for(int j = 0; j < i; j++){
                    int temp = sum[i] - sum[j];
                    if(temp == k) res++;
                }
            }
            return res;
        }
    }