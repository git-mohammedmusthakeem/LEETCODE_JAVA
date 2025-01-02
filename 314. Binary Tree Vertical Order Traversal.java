class Solution {
        private static class Node{
            int col;
            TreeNode node;
            public Node(int col, TreeNode node){
                this.col = col;
                this.node = node;
            }
        }
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;
            Map<Integer, List<Integer>> map = new TreeMap<>();
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(0, root));
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    Node node = q.poll();
                    List<Integer> list = map.containsKey(node.col) ? map.get(node.col): new ArrayList<>();
                    list.add(node.node.val);
                    map.put(node.col, list);
                    if(node.node.left != null) q.offer(new Node(node.col - 1, node.node.left));
                    if(node.node.right != null) q.offer(new Node(node.col + 1, node.node.right));
                }
            }
            for(List<Integer> list : map.values()){
                result.add(list);
            }
            return result;
        }
    }