class Solution {
        private int res = Integer.MAX_VALUE;
        public int getMinimumDifference(TreeNode root) {
            int[] range = getRange(root);
            return this.res;
        }
        private int[] getRange(TreeNode node){
            int cur = node.val;
            int[] left = null, right = null;
            if(node.left != null){
                left = getRange(node.left);
                this.res = Math.min(res, cur - left[1]);
            }
            if(node.right != null){
                right = getRange(node.right);
                this.res = Math.min(res, right[0] - cur);
            }
            if(left == null && right == null) return new int[]{cur, cur};
            else if(left != null && right != null) return new int[]{left[0], right[1]};
            else{
                return left == null ? new int[]{cur, right[1]}: new int[]{left[0], cur};
            }
        }
    }