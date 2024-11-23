class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean check(TreeNode node, long min, long max){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }
}