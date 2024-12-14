class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> pre = new HashMap<>();
        for(int[] p : prerequisites){
            indegree[p[0]]++;
            List<Integer> temp = pre.containsKey(p[1]) ? pre.get(p[1]) : new ArrayList<>();
            temp.add(p[0]);
            pre.put(p[1], temp);
        }
        int[] order = new int[numCourses];
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            order[count++] = cur;
            if(pre.containsKey(cur)){
                List<Integer> temp = pre.get(cur);
                for(Integer t : temp){
                    indegree[t]--;
                    if(indegree[t] == 0) queue.add(t);
                }
            }
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] != 0){
                return new int[0];
            }
        }
        return order;
    }
}