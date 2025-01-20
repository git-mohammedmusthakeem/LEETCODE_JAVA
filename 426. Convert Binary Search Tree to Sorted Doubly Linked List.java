class Solution {
        private Node dummy, cur;
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            this.dummy = new Node(0, null, null);
            this.cur = dummy;
            dfs(root);
            cur.right = dummy.right;
            dummy.right.left = cur;
            return dummy.right;
        }
        private void dfs(Node node){
            if(node == null) return;
            dfs(node.left);
            cur.right = new Node(node.val, cur, null);
            cur = cur.right;
            dfs(node.right);
        }
    }