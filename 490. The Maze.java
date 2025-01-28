class Solution {
		private static final int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
		private int[][] maze;
		private int[] destination;
		private Set<Integer> visited;
		private int height;
		private int width;
		public boolean hasPath(int[][] maze, int[] start, int[] destination) {
			if(start[0] == destination[0] && start[1] == destination[1]) return true;
			this.maze = maze;
			if(maze == null || maze.length == 0) return true;
			this.destination = destination;
			visited = new HashSet<>();
			this.height = maze.length;
			this.width = maze[0].length;
			visited.add(start[0] * width + start[1]);
			for(int d = 0; d < 4; d++)
				if(dfs(start, d)) return true;
			return false;
		}
		private boolean dfs(int[] cur, int dir){
			for(int d = 0; d < 4; d++){
				if(dir == d || dir + d == 3) continue;
				int tx = cur[0], ty = cur[1];
				while(tx >= 0 && tx < height && ty >= 0 && ty < width && this.maze[tx][ty] == 0){
					tx += this.dir[d][0];
					ty += this.dir[d][1];
				}
				tx -= this.dir[d][0];
				ty -= this.dir[d][1];
				if(tx == destination[0] && ty == destination[1]) return true;
				if(!visited.contains(tx * width + ty)){
					visited.add(tx * width + ty);
					if(dfs(new int[]{tx, ty}, d)) return true;
				}
			}
			return false;
		}
	}
