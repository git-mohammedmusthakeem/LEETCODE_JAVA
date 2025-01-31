public class TheMazeII {
	public static class Node{
		int row, col, l;
		public Node(int row, int col, int l){
			this.row = row;
			this.col = col;
			this. l = l;
		}
	}
	 public static int shortestDistance(int[][] maze, int[] start, int[] destination){
		 if(maze == null || maze[0].length == 0) return 0;
		 int height = maze.length, width = maze[0].length;
		 int[][] path = new int[height][width];
		 int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		 for(int i = 0; i < height; i++)
			 for(int j = 0; j < width; j++)
				 path[i][j] = Integer.MAX_VALUE;
		 LinkedList<Node> queue = new LinkedList<>();
		 queue.add(new Node(start[0], start[1], 0));
		 while(!queue.isEmpty()){
			 Node cur = queue.poll();
			 if(cur.l > path[cur.row][cur.col]) continue;
			 path[cur.row][cur.col] = cur.l;
			 for(int i = 0; i < 4; i++){
				 int row = cur.row, col = cur.col, l = cur.l;
				 while(row >= 0 && row < height && col >= 0 && col < width && maze[row][col] == 0){
					 row += dir[i][0];
					 col += dir[i][1];
					 l ++;
				 }
				 row -= dir[i][0];
				 col -= dir[i][1];
				 l--;
				 if(l >= path[destination[0]][destination[1]])
				 	continue;
				 if(l < path[row][col]){
					 queue.add(new Node(row,col, l));
				 }
			 }
		 }
		 return path[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1: path[destination[0]][destination[1]];
	 }
	 public static void main(String[] args) {
		 int[][] maze = new int[][]{{0, 0, 1, 0, 0},{0, 0, 0, 0, 0},{0, 0, 0, 1, 0},{1, 1, 0, 1, 1},{0, 0, 0, 0, 0}};
		 System.out.println(shortestDistance(maze, new int[]{0, 4}, new int[]{4,4}));
	}
}