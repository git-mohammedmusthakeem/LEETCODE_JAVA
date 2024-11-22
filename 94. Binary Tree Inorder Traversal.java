class Solution {
		private List<Integer> result;
		public List<Integer> inorderTraversal(TreeNode root) {
			this.result = new ArrayList<>();
			dfs(root);
			return this.result;
		}
		private void dfs(TreeNode node){
			if(node == null) return;
			dfs(node.left);
			this.result.add(node.val);
			dfs(node.right);
		}
	}