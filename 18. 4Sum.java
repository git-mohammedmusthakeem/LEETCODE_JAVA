class Solution {
	    public List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if(nums == null || nums.length < 4) return result;
	        Arrays.sort(nums);
	        int len = nums.length;
	        for(int i = 0; i < len - 3; i++){
	            for(int j = i+1; j < len - 2; j++){
	                int left = j + 1; int right = len - 1;
	                while(left < right){
	                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
	                    if(temp == target){
	                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
	                        left++;right--;
	                        while(left < right && nums[left-1] == nums[left])   left++;
	                        while(left < right && nums[right+1] == nums[right]) right--;
	                    }else if(temp < target){
	                        left++;
	                    }else{
	                        right--;
	                    }
	                }
	                while(j < len - 2 && nums[j + 1] == nums[j])  j++;//Remove duplicate.
	            }
	            while(i < len-3 && nums[i + 1] == nums[i])   i++;//Remove duplicate.
	        }
	        return result;
	    }
	}