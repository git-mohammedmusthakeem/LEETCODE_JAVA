class Solution {
		public int rob(TreeNode root) {
			return dfs(root)[0];
		}
		private int[] dfs(TreeNode root){
			int[] max = {0, 0}; 
			if(root != null){
				int[] maxLeft = dfs(root.left);
				int[] maxRight = dfs(root.right);
				max[1] = maxLeft[0] + maxRight[0];	
				max[0] = Math.max(maxLeft[1] + maxRight[1] + root.val, max[1]);
			}
			return max;
		}
	}