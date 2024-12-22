class Solution {
        private int res = 0;
        private TreeNode root;
        public int countUnivalSubtrees(TreeNode root) {
            if(root == null) return 0;
            this.root = root;
            subTreeValue(root);
            return res;
        }
        // return a value
        // if -1: means current tree is not unival
        // otherwise will return the univalue
        private int subTreeValue(TreeNode node){
            if(node.left == null && node.right == null){    // leaf is always true.
                res += 1;
                return node.val;
            }
            int left = -1, right = -1;
            if(node.left != null) left = subTreeValue(node.left);
            if(node.right != null) right = subTreeValue(node.right);
            if(node.left != null && node.right != null && left != -1 && right != -1){
                if(left == right && left == node.val){
                    res += 1;
                    return left;
                }
            }else if(node.right == null && left != -1){ // right subtree is empty
                if(left == node.val){
                    res += 1;
                    return left;
                }
            }else if(node.left == null && right != -1){
                if(right == node.val){
                    res += 1;
                    return right;
                }
            }
            return -1;
        }
    }