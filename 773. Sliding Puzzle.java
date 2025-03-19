class Solution {
        private static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public int slidingPuzzle(int[][] board) {
            Set<String> visited = new HashSet<>();
            int step = 0;
            String target = "123450";
            StringBuilder sb = new StringBuilder();
            for(int[] bb : board){
                for(int b : bb)
                    sb.append(b);
            }
            String initial = sb.toString();
            if(initial.equals(target)) return 0;
            Queue<String> q = new LinkedList<>();
            q.offer(initial);
            visited.add(initial);
            while(!q.isEmpty()){
                int size = q.size();
                step++;
                for(int k = 0; k < size; k++){
                    String s = q.poll();
                    int index = s.indexOf("0");
                    int row = index / 3, col = index % 3;
                    int tx = 0, ty = 0;
                    for(int d = 0; d < 4; d++){
                        tx = row + dir[d][0];
                        ty = col + dir[d][1];
                        if(tx >= 0 && tx < 2 && ty >= 0 && ty < 3){
                            String next = swap(s, tx * 3 + ty, index);
                            if(visited.contains(next)) continue;
                            if(next.equals(target)) return step;
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            return -1;
        }
    
        private String swap(String s, int a, int b){
            char[] arr = new String(s).toCharArray();
            char temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            return new String(arr);
        }
    }