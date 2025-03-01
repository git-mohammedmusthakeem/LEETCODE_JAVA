class Solution {
        private int result;
        public int longestUnivaluePath(TreeNode root) {
            if(root == null) return 0;
            getPath(root);
            return this.result - 1;
        }
        private int getPath(TreeNode node){
            if(node == null) return 0;
            int left = getPath(node.left);
            int right = getPath(node.right);
            int res = 1 + ((node.left == null || node.left.val == node.val) ? left: 0)
                + ((node.right == null || node.right.val == node.val) ? right: 0);
            this.result = Math.max(result, res);
            return Math.max((node.left == null || node.left.val == node.val) ? left: 0, 
                           (node.right == null || node.right.val == node.val) ? right: 0) + 1;
        }
    }