class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 1; i < nums.length; i++){
                nums[i] += nums[i - 1];
            }
            int max = 0;
            map.put(0, -1);
            for(int i = 0; i < nums.length; i++){
                if(map.containsKey(nums[i] - k)){
                    max = Math.max(max, i - map.get(nums[i] - k));
                }
                if(!map.containsKey(nums[i])){
                    map.put(nums[i], i);
                }
            }
            return max;
        }
    }