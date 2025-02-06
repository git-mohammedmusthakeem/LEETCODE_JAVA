class Solution {
      private int[] uf;
      private int num;
      public int findCircleNum(int[][] M) {
          if(M == null || M.length == 0) return 0;
          this.num = M.length;
          uf = new int[num];
          for(int i = 0; i < num; i++) uf[i] = i;
          for(int i = 0; i < num; i++){
              for(int j = i + 1; j < num; j++){
                  if(M[i][j] == 1){ //means student i and j are friends
                      union(i, j);
                  }
              }
          }
          int res = 0;
          for(int i = 0; i < uf.length; i++){
              if(uf[i] == i)
                  res++;
          }
          return res;
      }
      private void union(int i, int j){
          int p = find(i);
          int q = find(j);
          if(p != q){
              uf[p] = q;
          }
      }
      private int find(int i){
          if(uf[i] != i){
              uf[i] = find(uf[i]);
          }
          return uf[i];
      }
  }