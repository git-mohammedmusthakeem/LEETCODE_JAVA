class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return pathCount(root, 0, sum);
    }
    private static boolean pathCount(TreeNode node, int count, int sum){
        if(node == null){
            if(count == sum)
                return true;
            return false;
        }else{
            if(node.left == null)
                return pathCount(node.right, count + node.val, sum);
            else if(node.right == null)
                return pathCount(node.left, count + node.val, sum);
            else
                return pathCount(node.left, count + node.val, sum) || pathCount(node.right, count + node.val, sum);
        }
    }
}