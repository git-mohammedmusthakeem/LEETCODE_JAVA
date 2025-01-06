class Solution {
		public int largestBSTSubtree(TreeNode root) {
			if(root == null) return 0;
			int[] res = helper(root);
			return res[3];
		}
		private int[] helper(TreeNode node){// 0: isBST, 1: min, 2: max, 3: number of nodes
			int[] left = new int[]{1, node.val, node.val, 0};
			int[] right = new int[]{1, node.val, node.val, 0};
			if(node.left != null) left = helper(node.left);
			if(node.right != null) right = helper(node.right);
			boolean isBST = left[0] == 1 
				&& right[0] == 1 
				&& (node.left != null ? node.val > left[2]: true) 
				&& (node.right != null ? node.val < right[1]: true);
			int number = isBST ? 1 + left[3] + right[3] : Math.max(left[3], right[3]);
			return new int[]{isBST ? 1: 0, left[1], right[2], number};
		}
	}