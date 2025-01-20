class Solution {
        private int[][] grid;
        public Node construct(int[][] grid) {
            this.grid = grid;
            int len = grid.length;
            return dfs(0, grid.length - 1, 0, grid.length - 1);
        }
        private Node dfs(int xs, int xe, int ys, int ye){
            Node node = new Node();
            if(xs == xe){
                node.val = (grid[xs][ys] == 1);
                node.isLeaf = true;
                return node;
            }
            Node upLeft = dfs(xs, xs + (xe - xs) / 2, ys, ys + (ye - ys) / 2);
            Node upRight = dfs(xs, xs + (xe - xs) / 2, ys + (ye - ys) / 2 + 1, ye);
            Node bottomLeft = dfs(xs + (xe - xs) / 2 + 1, xe, ys, ys + (ye - ys) / 2);
            Node bottomRight = dfs(xs + (xe - xs) / 2 + 1, xe, ys + (ye - ys) / 2 + 1, ye);
            if(bottomLeft.isLeaf && bottomRight.isLeaf && upLeft.isLeaf && upRight.isLeaf
              && bottomLeft.val == bottomRight.val && bottomRight.val == upLeft.val && upLeft.val == upRight.val){
                node.isLeaf = true;
                node.val = bottomLeft.val;
            }else{
                node.bottomLeft = bottomLeft;
                node.bottomRight = bottomRight;
                node.topLeft = upLeft;
                node.topRight = upRight;
            }
            return node;
        }
    }