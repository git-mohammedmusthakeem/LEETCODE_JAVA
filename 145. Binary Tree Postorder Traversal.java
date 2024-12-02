class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        post(root, result);
        return result;
    }
    private void post(TreeNode node, List<Integer> result){
        if(node == null) return;
        post(node.left, result);
        post(node.right, result);
        result.add(node.val);
    }
}