class Solution {
        private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public int shortestDistance(int[][] grid) {
            Set<Integer> buildings = new HashSet<>();
            int height = grid.length, width = grid[0].length;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 1) buildings.add(i * width + j);
                }
            }
            int min = Integer.MAX_VALUE;
            int count = buildings.size();
            for(int i = 0; i < height; i++){
                LABEL:
                for(int j = 0; j < width; j++){
                    if(grid[i][j] != 0) continue;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    Set<Integer> visited = new HashSet<>();
                    int reach = 0;
                    int step = 0;
                    int temp = 0;
                    Set<Integer> check = new HashSet<>(buildings);
                    while(!q.isEmpty() && reach != count){
                        int size = q.size();
                        step++;
                        for(int k = 0; k < size; k++){
                            int[] cur = q.poll();
                            if(check.contains(cur[0] * width + cur[1])){
                                temp += step - 1;
                                if(temp >= min) continue LABEL;
                                check.remove(cur[0] * width + cur[1]);
                                reach++;
                                continue;
                            }
                            int tx = 0, ty = 0;
                            for(int d = 0; d < 4; d++){
                                tx = cur[0] + dir[d][0];
                                ty = cur[1] + dir[d][1];
                                if(tx >= 0 && tx < height && ty >= 0 && ty < width && !visited.contains(tx * width + ty) && grid[tx][ty] != 2){
                                    visited.add(tx * width + ty);
                                    q.offer(new int[]{tx, ty});
                                }
                            }
                        }
                    }
                    if(reach == count) min = Math.min(min, temp);
                }
            }
            return min == Integer.MAX_VALUE ? -1: min;
        }
    }