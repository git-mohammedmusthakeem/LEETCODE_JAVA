class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                List<Integer> temp = new ArrayList<>();
                int size = q.size();
                for(int i  = 0; i < size; i++){
                    Node node = q.poll();
                    temp.add(node.val);
                    for(Node n : node.children){
                        q.offer(n);
                    }
                }
                result.add(temp);
            }
            return result;
        }
    }
   