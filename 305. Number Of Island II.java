public class NumberOfIsland {
	public static int numIslands(int[][] land){
		if(land == null || land.length == 0) return 0;
		int result = 0;
		int height = land.length;
		int width = land[0].length;
		boolean[][] visited = new boolean[height][width];
		LinkedList<Integer> q = new LinkedList<>();
		int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(land[i][j] != 1 || visited[i][j]) continue;
				result++;
				q.add(i * width + j);
				while(!q.isEmpty()){
					Integer cur = q.poll();
					int row = cur / width, col = cur % width;
					visited[row][col] = true;
					for(int d = 0; d < 4; d++){
						int tempRow = row, tempCol = col;
						tempRow += dir[d][0];
						tempCol += dir[d][1];
						if(tempRow >= 0 && tempRow < height && tempCol >= 0 && tempCol < width && land[tempRow][tempCol] == 1 && !visited[tempRow][tempCol]){
							q.add(tempRow * width + tempCol);
						}
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] land = new int[][]{{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0}, {0,0,0,0,0}};
		System.out.println(numIslands(land));
	}
}