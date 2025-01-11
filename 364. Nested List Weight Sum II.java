class Solution {
      private int max = 0;
      private int sum;
      public int depthSumInverse(List<NestedInteger> nestedList) {
          if(nestedList == null || nestedList.size() == 0) return 0;
          maxDepth(nestedList, 1);
          dfs(nestedList, 1);
          return sum;
      }
      private void dfs(List<NestedInteger> nestedList, int depth){
          int cur = 0;
          List<NestedInteger> next = new ArrayList<>();
          for(NestedInteger num : nestedList){
              if(num.isInteger()){
                  cur += num.getInteger();
              }else{
                  next.addAll(num.getList());
              }
          }
          if(!next.isEmpty()) dfs(next, depth + 1);
          sum += cur * (max - depth + 1);
      }
      private void maxDepth(List<NestedInteger> nestedList, int depth){
          List<NestedInteger> next = new ArrayList<>();
          max = Math.max(max, depth);
          for(NestedInteger num : nestedList){
              if(!num.isInteger()) next.addAll(num.getList());
          }
          if(!next.isEmpty()) maxDepth(next, depth + 1);
      }
  }