class Solution {
      private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      public int swimInWater(int[][] grid) {
          PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
              @Override
              public int compare(int[] a, int[] b){
                  return a[0] - b[0];
              }
          });
          int n = grid.length;
          pq.offer(new int[]{grid[0][0], 0});
          Set<Integer> seen = new HashSet<>();
          seen.add(0);
          while(!pq.isEmpty()){
              int[] node = pq.poll();
              int t = node[0];
              int row = node[1] / n;
              int col = node[1] % n;
              if(row == n - 1 && col == n - 1) return t;
              int tx = 0, ty = 0;
              for(int d = 0; d < 4; d++){
                  tx = row + dir[d][0];
                  ty = col + dir[d][1];
                  if(seen.contains(tx * n + ty) || tx < 0 || tx >= n || ty < 0 || ty >= n) continue;
                  seen.add(tx * n + ty);
                  pq.offer(new int[]{Math.max(t, grid[tx][ty]), tx * n + ty});
              }
          }
          return -1;
      }
  }