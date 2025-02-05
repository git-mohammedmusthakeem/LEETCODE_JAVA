class Solution {
		public List<Integer> boundaryOfBinaryTree(TreeNode root) {
			// first get the left boundry.
			List<Integer> result = new ArrayList<>();
			TreeNode cur = null;
			if(root == null) return result;
			if(root.left == null && root.right == null){
				result.add(root.val);
				return result;
			}
			List<Integer> left = new ArrayList<>();
			cur = root.left;
			while(cur != null){
				left.add(cur.val);
				cur = cur.left != null ? cur.left: cur.right;
			}
			cur = root.right;
			List<Integer> right = new ArrayList<>();
			while(cur != null){
				right.add(cur.val);
				cur = cur.right != null ? cur.right: cur.left;
			}
			List<Integer> leaves = new ArrayList<>();
			dfs(root, leaves);
			result.add(root.val);
			result.addAll(left);
			for(int i = ((left.size() != 0 && left.get(left.size() -  1) == leaves.get(0)) ? 1: 0);
				i < (right.size() != 0 && leaves.get(leaves.size() - 1) == right.get(right.size() - 1) ? leaves.size() - 1: leaves.size());
				i++)  result.add(leaves.get(i));
			for(int i = right.size() - 1; i >= 0; i--) result.add(right.get(i));
			return result;
		}
		private void dfs(TreeNode node, List<Integer> list){
			if(node.left == null && node.right == null){
				list.add(node.val);
				return;
			}
			if(node.left != null) dfs(node.left, list);
			if(node.right != null) dfs(node.right, list);
		}
	}