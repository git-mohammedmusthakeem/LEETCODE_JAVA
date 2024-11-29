class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        List<Integer> temp = new LinkedList<>();
        dfs(root, temp, 0);
        int result = 0;
        for(Integer s : temp) result += s;
        return result;
    }
    private void dfs(TreeNode node, List<Integer> sum, int cur){
        cur = cur * 10 + node.val;
        if(node.left == null && node.right == null)
            sum.add(cur);
        else{
            if(node.left != null) dfs(node.left, sum, cur);
            if(node.right != null) dfs(node.right, sum, cur);
        }
    }
}