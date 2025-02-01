class Solution {
      private Map<Integer, Integer> map;
      private int max;
      public int[] findFrequentTreeSum(TreeNode root) {
          this.map = new HashMap<>();
          if(root == null) return new int[]{};
          getSubtreeSum(root);
          List<Integer> res = new ArrayList<>();
          for(Map.Entry<Integer, Integer> entry: map.entrySet()){
              if(entry.getValue() == max){
                  res.add(entry.getKey());
              }
          }
          int size = res.size();
          int index = 0;
          int[] result = new int[size];
          for(Integer n : res)
              result[index++] = n;
          return result;
      }
      private int getSubtreeSum(TreeNode node){
          if(node.left == null && node.right == null){
              int appear = map.containsKey(node.val) ? map.get(node.val): 0;
              map.put(node.val, appear + 1);
              max = Math.max(max, appear + 1);
              return node.val;
          }else{
              int left = 0, right = 0;
              if(node.left != null) left = getSubtreeSum(node.left);
              if(node.right != null) right = getSubtreeSum(node.right);
              int sum = node.val + left + right;
              int appearSum = map.containsKey(sum) ? map.get(sum): 0;
              map.put(sum, appearSum + 1);
              max = Math.max(max, appearSum + 1);
              return sum;
          }
      }
  }