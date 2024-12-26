public class Solution extends Relation {
      public int findCelebrity(int n) {
          LABEL:
          for(int i = 0; i < n; i++){
              for(int j = 0; j < n; j++){
                  if(i == j) continue;
                  if(knows(i, j) || !knows(j, i)) continue LABEL;
              }
              return i;
          }
          return -1;
      }
  }