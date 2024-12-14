class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] pre : prerequisites){
            List<Integer> temp = adj.containsKey(pre[0]) ? adj.get(pre[0]) : new ArrayList<Integer>();
            temp.add(pre[1]);
            adj.put(pre[0], temp);
            indegree[pre[1]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)  queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int pre = queue.poll();
            count++;
            if(adj.containsKey(pre)){
                List<Integer> list = adj.get(pre);
                for(Integer v : list){
                    indegree[v]--;
                    if(indegree[v] == 0)
                        queue.add(v);
                }
            }
        }
        return count == numCourses;
    }
}