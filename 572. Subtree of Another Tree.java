class Solution {
      public boolean isSubtree(TreeNode s, TreeNode t) {
          if(s != null && t != null) return same(s, t) || (isSubtree(s.left, t) || isSubtree(s.right, t));
          else if(s != null || t != null) return false;
          else return true;
      }
      private boolean same(TreeNode s, TreeNode t){
          if(s != null && t != null) return s.val == t.val && same(s.left, t.left) && same(s.right, t.right);
          else if(s != null || t != null) return false;
          else return true;
      }
  }