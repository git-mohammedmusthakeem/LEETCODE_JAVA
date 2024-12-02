class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preorderTraversal(root, result);
        return result;
    }
    private void preorderTraversal(TreeNode node, List<Integer> result){
        if(node == null) return;
        result.add(node.val);
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }
}