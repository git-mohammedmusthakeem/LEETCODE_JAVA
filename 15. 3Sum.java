class Solution {
	    public List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums);
	        int len = nums.length;
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        for(int i = 0; i < len - 2; i++){
	            if(i > 0 && nums[i] == nums[i-1]) continue;//Check current and previous, if duplicate, skip.
	            int left = i + 1;
	            int right = len - 1;
	            int target = -nums[i];
	            while(left < right){	//break utill left and right pointer superpose. 
	                if(nums[left] + nums[right] == target){
	                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
	                    left ++; right --;
	                    //Remove duplicate left and right
	                    while(left < right && nums[left - 1] == nums[left])    left++;
	                    while(right > left && nums[right + 1] == nums[right])    right--;
	                }else if(nums[left] + nums[right] < target){//nums is in order
	                    left++;
	                }else   right--;
	            }
	        }
	        return result;
	    }
	}