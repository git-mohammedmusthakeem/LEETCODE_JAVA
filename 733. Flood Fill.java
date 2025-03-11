class Solution {      
      private int height;
      private int width;
      private int original;
      public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
          if(image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor)
              return image;
          height = image.length;
          width = image[0].length;
          original = image[sr][sc];
          dfs(image, sr, sc, newColor);
          return image;
      }
      private void dfs(int[][] image, int r, int c, int newColor){
          image[r][c] = newColor;
          int tx = 0, ty = 0;
          for(int i = 0; i < 4; i++){
              tx = r + dir[i][0];
              ty = c + dir[i][1];
              if(tx >= 0 && tx < height && ty >= 0 && ty < width && image[tx][ty] == original){
                  dfs(image, tx, ty, newColor);
              }
          }
      }
  }