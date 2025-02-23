class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if(root == null) return root;
            TreeNode left = trimBST(root.left, L, R);
            root.left = left;
            TreeNode right = trimBST(root.right, L, R);
            root.right = right;
            if(root.val < L || root.val > R){
                if(root.left == null) return root.right;
                else{
                    TreeNode node = root.left;
                    while(node.right != null){
                        node = node.right;
                    }
                    node.right = root.right;
                    root.right = null;
                    return root.left;
                }
            }
            return root;
        }
    }