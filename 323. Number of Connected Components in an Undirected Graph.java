class Solution {
		private int[] uf;
		public int countComponents(int n, int[][] edges) {
			this.uf = new int[n];
			for(int i = 0; i < n; i++)
				uf[i] = i;
			for(int[] edge : edges){
				union(edge[0], edge[1]);
			}
			int count = 0;
			for(int i = 0; i < n; i++)
				if(uf[i] == i)
					count++;
			return count;
		}
		private int find(int i){
			if(uf[i] != i){
				uf[i] = find(uf[i]);
			}
			return uf[i];
		}
		private void union(int i, int j){
			int x = find(i);
			int y = find(j);
			uf[x] = y;
		}
	}