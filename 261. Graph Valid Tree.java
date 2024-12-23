class Solution {
        private int[] uf;
        public boolean validTree(int n, int[][] edges) {
            this.uf = new int[n];
            for(int i = 0; i < n; i++) uf[i] = i;
            for(int[] edge : edges){
                int p = find(edge[0]);
                int q = find(edge[1]);
                if(p == q) return false;
                uf[p] = q;
            }
            int count = 0;
            for(int i = 0; i < n; i++)
                if(uf[i] == i) count++;
            return count == 1;
        }
        private int find(int i){
            if(uf[i] != i){
                uf[i] = find(uf[i]);
            }
            return uf[i];
        }
    }