class Solution {
        private List<TreeNode> result;
        private int index = 0;
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            result = new ArrayList<>();
            dfs(root, p);
            if(index >= result.size()) return null;
            return result.get(index);
        }
        private void dfs(TreeNode node, TreeNode p){
            if(node == null) return;
            else{
                dfs(node.left, p);
                result.add(node);
                if(p == node) index = result.size();
                dfs(node.right, p);
            }
        }
    }