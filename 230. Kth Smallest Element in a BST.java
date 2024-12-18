class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        List<Integer> result = new ArrayList<>();
        inorder(root, result, k);
        return result.get(k - 1);
    }
    private void inorder(TreeNode root, List<Integer> result, int k){
        if(root == null) return;
        inorder(root.left, result, k);
        result.add(root.val);
        if(result.size() == k) return;
        inorder(root.right, result, k);
    }
}