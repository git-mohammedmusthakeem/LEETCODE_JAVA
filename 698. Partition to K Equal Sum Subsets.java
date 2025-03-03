class Solution {
		public boolean canPartitionKSubsets(int[] nums, int k) {
			if(nums == null || nums.length < 4) return false;
			int sum = 0;
			for(int num : nums) sum += num;
			if(sum % k != 0) return false;
			return dfs(nums, 0, k, 0, sum / k, new boolean[nums.length]);
		}
		private boolean dfs(int[] nums, int count, int k, int cur, int sum, boolean[] visited){
			if(cur == sum){
				if(++count == k) return true;
				else{
					return dfs(nums, count, k, 0, sum, visited);
				}
			}else if(cur < sum){
				for(int i = 0; i < nums.length; i++){
					if(visited[i]) continue;
					visited[i] = true;
					if(dfs(nums, count, k, cur + nums[i], sum, visited)) return true;
					visited[i] = false;
				}
			}
			return false;
		}
	}