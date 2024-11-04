class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> map = new HashMap<>();
	        int numLength = nums.length;
	        for(int i = 0; i < numLength; i++){
	            if(!map.containsKey(target - nums[i])){
	                map.put(nums[i], i);
	            }else{
	                return new int[]{i, map.get(target - nums[i])};
	            }
	        }
	        return null;
	    }
	}
