class Solution {
		private static final class Node{
			TreeNode node;
			int index;
			public Node(TreeNode node, int index){
				this.node = node;
				this.index = index;
			}
		}
		public int widthOfBinaryTree(TreeNode root) {
			if(root == null) return 0;
			Queue<Node> q = new LinkedList<>();
			int res = 0;
			q.offer(new Node(root, 1));
			while(!q.isEmpty()){
				int size = q.size();
				int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
				for(int sz = 0; sz < size; sz++){
					Node node = q.poll();
					int index = node.index;    
					left = Math.min(index, left);
					right = Math.max(right, index);
					if(node.node.left != null) q.offer(new Node(node.node.left, 2 * index - 1));
					if(node.node.right != null) q.offer(new Node(node.node.right, 2 * index));
				}
				res = Math.max(res, right - left + 1);
			}
			return res;
		}
	}