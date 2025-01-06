class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] str : tickets){
            String src = str[0], dest = str[1];
            if(map.containsKey(src))
                map.get(src).offer(dest);
            else{
                PriorityQueue<String> pq = new PriorityQueue<String>();
                pq.offer(dest);
                map.put(src, pq);
            }
        }
        dfs(res, map, "JFK");
        return res;
    }
    private void dfs(LinkedList<String> res, Map<String, PriorityQueue<String>> map, String src){
        PriorityQueue<String> pq = map.get(src);
        while(pq != null && !pq.isEmpty()){
            dfs(res, map, pq.poll());
        }
        res.addFirst(src);
    }
}