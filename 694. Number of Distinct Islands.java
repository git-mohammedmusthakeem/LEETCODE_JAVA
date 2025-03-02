class Solution {
        private Set<String> shapes;
        private int[][] grid;
        private int height;
        private int width;
        private static final int[][] dir = new int[][]{{0, 1},{1, 0},{0, -1}, {-1, 0}};
        private static final char[] dStr = new char[]{'r', 'd', 'l', 'u'};
        public int numDistinctIslands(int[][] grid) {
            if(grid == null || grid.length == 0) return 0;
            this.grid = grid;
            this.shapes = new HashSet<>();
            this.height = grid.length;
            this.width = grid[0].length;
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    if(grid[i][j] == 0) continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append('s');
                    grid[i][j] = 0;
                    dfs(i, j, sb);
                    this.shapes.add(sb.toString());
                }
            }
            return shapes.size();
        }
        private void dfs(int x, int y, StringBuilder sb){
            int tx = 0, ty = 0;
            for(int d = 0; d < 4; d++){
                tx = x + dir[d][0];
                ty = y + dir[d][1];
                if(tx >= 0 && tx < height && ty >= 0 && ty < width && grid[tx][ty] == 1){
                    sb.append(dStr[d]);
                    grid[tx][ty] = 0;
                    dfs(tx, ty, sb);
                }
            }
            sb.append('b');
        }
    }