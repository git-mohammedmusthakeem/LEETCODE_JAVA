class BSTIterator {
	    private Queue<Integer> q;
	    public BSTIterator(TreeNode root) {
	        q = new LinkedList<>();
	        inorder(root);
	    }
	    private void inorder(TreeNode node){
	        if(node == null) return;
	        inorder(node.left);
	        q.offer(node.val);
	        inorder(node.right);
	    }

	    /** @return the next smallest number */
	    public int next() {
	        return q.poll();
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !q.isEmpty();
	    }
	}