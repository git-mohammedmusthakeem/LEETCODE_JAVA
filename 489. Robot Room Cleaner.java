class Solution {
        Set<String> visited;
        private Robot robot;
        private static final int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1 , 0}, {0, -1}};
        public void cleanRoom(Robot robot) {
            this.visited = new HashSet<>();
            this.robot = robot;
            dfs(0, 0, 0);
        }
        private void dfs(int x, int y, int d){
            robot.clean();
            visited.add(x + "_" + y);
            int tx = 0, ty = 0;
            for(int i = d; i < 4 + d; i++){
                tx = x + dir[i % 4][0];
                ty = y + dir[i % 4][1];
                if(!visited.contains(tx + "_" + ty) && robot.move()){
                    dfs(tx, ty, i % 4);
                    robot.turnRight();
                    robot.turnRight();
                    robot.move();
                    robot.turnRight();
                    robot.turnRight();
                }
                robot.turnRight();
            }
        }
    }