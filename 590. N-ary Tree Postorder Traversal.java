// Definition for a Node.
  class Node {
      public int val;
      public List<Node> children;

      public Node() {}

      public Node(int _val,List<Node> _children) {
          val = _val;
          children = _children;
      }
  };
  */
  class Solution {
      private List<Integer> result;
      public List<Integer> postorder(Node root) {
          this.result = new ArrayList<>();
          if(root == null) return this.result;
          dfs(root);
          return this.result;
      }
      private void dfs(Node node){
          for(int i = 0; i < node.children.size(); i++){
              dfs(node.children.get(i));
          }
          result.add(node.val);
      }
  }