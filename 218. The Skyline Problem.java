class Solution {
        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> result = new ArrayList<>();
            List<int[]> building = new ArrayList<>();
            for(int[] b : buildings){
                building.add(new int[]{b[0], -b[2]});
                building.add(new int[]{b[1], b[2]});
            }
            Collections.sort(building, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if(a[0] != b[0]) return a[0] - b[0];
                    return a[1] - b[1];
                }
            });
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
                @Override
                public int compare(Integer h1, Integer h2){
                    return h2 - h1;
                }
            });
            pq.offer(0);
            int prev = 0;
            for(int[] h : building){
                if(h[1] < 0) pq.offer(-h[1]);
                else pq.remove(h[1]);
                int cur = pq.peek();
                if(cur != prev){
                    result.add(new int[]{h[0], cur});
                    prev = cur;
                }
            }
            return result;
        }
    }