class Solution {
        private Set<Integer> set;
        public boolean findTarget(TreeNode root, int k) {
            if(root == null) return false;
            this.set = new HashSet<>();
            return dfs(root, k);
        }
        private boolean dfs(TreeNode node, int k){
            if(set.contains(k - node.val)) return true;
            else{
                set.add(node.val);
                return (node.left != null ? dfs(node.left, k): false)
                    || (node.right != null ? dfs(node.right, k): false);
            }
        }
    }