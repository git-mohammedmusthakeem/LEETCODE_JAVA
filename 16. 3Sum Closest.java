class Solution {
	    public int threeSumClosest(int[] nums, int target) {
	        int len = nums.length;
	        int d = Integer.MAX_VALUE;
	        Arrays.sort(nums);
	        for(int i = 0; i < len-2; i++){
	            if(i > 0 && nums[i-1] == nums[i]) continue;
	            int left = i+1; int right=len-1;
	            int tempTarget = target - nums[i];
	            while(left < right){
	                if(nums[left] + nums[right] == tempTarget) return target;
	                else if(nums[left] + nums[right] < tempTarget){
	                    if(Math.abs(target - nums[i] - nums[left] - nums[right]) < Math.abs(d))
	                        d = target-nums[i] - nums[left] - nums[right];
	                    left++;
	                } 
	                else{
	                    if(Math.abs(target - nums[i] - nums[left] - nums[right]) < Math.abs(d))
	                        d = target-nums[i] - nums[left] - nums[right];
	                    right--;
	                }
	            }
	        }
	        return target - d;
	    }
	}