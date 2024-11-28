class Solution {
		private int max = Integer.MIN_VALUE;
		public int maxPathSum(TreeNode root) {
			return Math.max(max(root), this.max);
		}
		private int max(TreeNode node){
			if(node == null) return 0;
			int left = Math.max(max(node.left), 0);
			int right = Math.max(max(node.right), 0);
			int res = Math.max(node.val, node.val + left + right);
			this.max = Math.max(max, res);
			return Math.max(node.val, Math.max(node.val + left, node.val + right));
		}
	}