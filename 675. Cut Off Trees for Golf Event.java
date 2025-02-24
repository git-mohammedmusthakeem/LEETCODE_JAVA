class Solution {
        private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public int cutOffTree(List<List<Integer>> forest) {
            int height = forest.size(), width = forest.get(0).size();
            int[][] map = new int[height][width];
            PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
                @Override
                public int compare(int[] n1, int[] n2){
                    return map[n1[0]][n1[1]] - map[n2[0]][n2[1]];
                }
            });
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    map[i][j] = forest.get(i).get(j);
                    if(map[i][j] != 0 && map[i][j] != 1)  pq.offer(new int[]{i, j});
                }
            }
            if(map[0][0] == 0) return -1;
            int res = 0;
            Queue<int[]> queue = new LinkedList<>();
            int[] cur = new int[]{0, 0};
            while(!pq.isEmpty()){
                int[] dest = pq.poll();
                queue.clear();
                queue.offer(cur);
                boolean found = false;
                boolean[][] visited = new boolean[height][width];
                visited[cur[0]][cur[1]] = true;
                int step = -1;
                while(!queue.isEmpty() && !found){
                    ++step;
                    int size = queue.size();
                    for(int i = 0; i < size; i++){
                        int[] node = queue.poll();
                        if(map[node[0]][node[1]] == map[dest[0]][dest[1]]){
                            found = true;
                            res += step;
                            break;
                        }
                        int tempRow = 0, tempCol = 0;
                        for(int d = 0; d < 4; d++){
                            tempRow = node[0] + dir[d][0];
                            tempCol = node[1] + dir[d][1];
                            if(tempRow >= 0 && tempRow < height && tempCol >= 0 && tempCol < width && map[tempRow][tempCol] != 0 && (map[tempRow][tempCol] >= map[node[0]][node[1]] || !visited[tempRow][tempCol])){
                                visited[tempRow][tempCol] = true;
                                queue.add(new int[]{tempRow, tempCol});
                            }
                        }
                    }
                    if(found) break;
                }
                if(found) cur = dest;
                else return -1;
            }
            return res;
        }
    }