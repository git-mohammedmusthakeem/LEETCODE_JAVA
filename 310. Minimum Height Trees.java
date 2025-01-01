class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if(n <= 0 || edges == null) return leaves;
        if(n == 1){
            leaves.add(0);
            return leaves;
        }
        List<Integer>[] map = new List[n];
        for(int i = 0; i < n; i++)
            map[i] = new ArrayList<Integer>();
        for(int[] arr: edges){
            map[arr[0]].add(arr[1]);
            map[arr[1]].add(arr[0]);
        }
        for(int i = 0; i < n; i++)
            if(map[i].size() == 1){
                leaves.add(i);
            }
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : leaves){
                Integer cur = map[i].get(0);
                map[cur].remove(map[cur].indexOf(i));
                if(map[cur].size() == 1)
                    newLeaves.add(cur);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}