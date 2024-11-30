public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return node == null ? null : dfs(node, map);
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map){
        if(map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode temp = new UndirectedGraphNode(node.label);
        map.put(node.label, temp);
        for(UndirectedGraphNode n : node.neighbors){
            temp.neighbors.add(dfs(n, map));
        }
        return temp;
    }
}