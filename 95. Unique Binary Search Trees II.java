class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if(n == 0) return result[0];
        result[0].add(null);
        for(int i = 1; i <= n; i++){
            result[i] = new ArrayList<>();
            for(int j = 0; j < i; j++){
                List<TreeNode> lefts = result[j];
                List<TreeNode> rights = result[i - 1 - j];
                for(TreeNode left : lefts){
                    for(TreeNode right : rights){
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = copyTree(right, j+1);
                        result[i].add(root);
                    }
                }
            }
        }
        return result[n];
    }
    private TreeNode copyTree(TreeNode root, int offset){
        if(root == null) return null;
        TreeNode node = new TreeNode(root.val + offset);
        node.left = copyTree(root.left, offset);
        node.right = copyTree(root.right, offset);
        return node;
    }
}