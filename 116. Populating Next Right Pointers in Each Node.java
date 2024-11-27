public class Solution {
    public void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> list = new LinkedList<>();
        if(root == null) return;
        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            TreeLinkNode node = list.poll();
            if(node.left != null) list.add(node.left);
            if(node.right != null) list.add(node.right);
            for(int i = 0; i < size - 1; i++){
                TreeLinkNode temp = list.poll();
                if(temp.left != null) list.add(temp.left);
                if(temp.right != null) list.add(temp.right);
                node.next = temp;
                node = temp;
            }
            node.next = null;
        }
    }
}