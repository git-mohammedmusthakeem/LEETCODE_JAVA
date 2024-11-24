class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        boolean order = true;
        Stack<TreeNode> q = new Stack<>();
        Stack<TreeNode> qr = new Stack<>();
        q.push(root);
        int size = 0;
        while(!q.isEmpty() || !qr.isEmpty()){
            if(order)
                size = q.size();
            else size = qr.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = null;
                if(order)
                    node = q.pop();
                else
                    node = qr.pop();
                temp.add(node.val);
                if(order){
                    if(node.left != null) qr.push(node.left);
                    if(node.right != null ) qr.push(node.right);
                }else{
                    if(node.right != null ) q.push(node.right);
                    if(node.left != null) q.push(node.left);
                }
            }
            order = !order;
            result.add(temp);
        }
        return result;
    }
}