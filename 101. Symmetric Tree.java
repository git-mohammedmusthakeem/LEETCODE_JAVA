class Solution {
      public boolean isSymmetric(TreeNode root) {
          if(root == null) return true;
          return symmetric(root.left, root.right);
      }
      private boolean symmetric(TreeNode left, TreeNode right){
          if(left == null && right == null) return true;
          else if(left == null || right == null) return false;
          else{
              return left.val == right.val && symmetric(left.right, right.left) && symmetric(left.left, right.right);
          }
      }
  }