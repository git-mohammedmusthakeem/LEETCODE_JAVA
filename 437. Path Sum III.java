class Solution {
        private int result;
        public int pathSum(TreeNode root, int sum) {
            if(root == null) return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                TreeNode node = q.poll();
                dfs(node, 0, sum);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            return result;
        }
        private void dfs(TreeNode node, int cur, int sum){
            if(node == null) return;
            if(cur + node.val == sum) result++;
            dfs(node.left, cur + node.val, sum);
            dfs(node.right, cur + node.val, sum);
        }
    }