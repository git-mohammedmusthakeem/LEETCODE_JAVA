class Solution {
		private TreeNode first, second, pre;
		public void recoverTree(TreeNode root) {
			inorder(root);
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}    
		private void inorder(TreeNode node){
			if(node == null) return;
			inorder(node.left);
			if(pre != null && pre.val > node.val){
				if(first == null) this.first = pre;
				this.second = node;
			}
			pre = node;
			inorder(node.right);
		}
	}