class Solution {
      private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      public int[][] updateMatrix(int[][] matrix) {
          int height = matrix.length, width = matrix[0].length;
          int[][] result = new int[height][width];
          for(int i = 0; i < height; i++)
              for(int j = 0; j < width; j++)
                  result[i][j] = 10000;
          for(int i = 0; i < height; i++){
              for(int j = 0; j < width; j++){
                  if(matrix[i][j] == 0){
                      result[i][j] = 0;
                      continue;   
                  }
                  LinkedList<int[]> queue = new LinkedList<>();
                  int dist = -1;
                  queue.add(new int[]{i, j});
                  boolean[][] visited = new boolean[height][width];
                  visited[i][j] = true;
                  boolean found = false;
                  while(!queue.isEmpty() && !found){
                      ++dist;
                      int size = queue.size();
                      for(int s = 0; s < size; s++){
                          int[] cur = queue.poll();
                          int tempRow = 0, tempCol = 0;
                          for(int d = 0; d < 4; d++){
                              tempRow = dir[d][0] + cur[0];
                              tempCol = dir[d][1] + cur[1];
                              if(tempRow >= 0 && tempRow < height && tempCol >= 0 && tempCol < width && !visited[tempRow][tempCol]){
                                  if(matrix[tempRow][tempCol] == 0 || result[tempRow][tempCol] != 10000){
                                      result[i][j] = Math.min(result[i][j], matrix[tempRow][tempCol] == 0 ? dist + 1: result[tempRow][tempCol] + dist + 1);
                                      found = true;
                                  }
                                  visited[tempRow][tempCol] = true;
                                  queue.add(new int[]{tempRow, tempCol});
                              }
                          }
                          if(found) break;
                      }
                  }
              }
          }
          return result;
      }
  }