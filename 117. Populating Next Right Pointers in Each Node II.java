public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            TreeLinkNode pre = null;
            for(int i = 0; i < len; i++){
                TreeLinkNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                if(pre != null){
                    pre.next = temp;
                }
                pre = temp;
            }
            pre.next = null;
        }
    }
}