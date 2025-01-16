class Solution {
        Map<String, Map<String, Double>> graph;
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            graph = new HashMap<>();
            for(int i = 0; i < equations.length; i++){
                // a / b = ratio => a = b * ratio
                String first = equations[i][0], second = equations[i][1];
                Map<String, Double> temp = graph.containsKey(first) ? graph.get(first): new HashMap<>();
                temp.put(second, values[i]);
                graph.put(first, temp);
                temp = graph.containsKey(second) ? graph.get(second): new HashMap<>();
                temp.put(first, 1/ values[i]);
                graph.put(second, temp);
            }
            double[] res = new double[queries.length];
            for(int i = 0; i < res.length; i++){
                String first = queries[i][0];
                String second = queries[i][1];
                if(!graph.containsKey(first) || !graph.containsKey(second)){
                    res[i] = -1D;
                    continue;
                }else{
                    res[i] = divide(first, second, new HashSet<>());
                }
            }
            return res;
        }
        private double divide(String first, String second, Set<String> visited){
            if(first.equals(second)) return 1D;
            else{
                for(String next : graph.get(first).keySet()){
                    if(visited.contains(next)) continue;
                    visited.add(next);
                    double d = divide(next, second, visited);
                    if(d > 0) return d * graph.get(first).get(next);
                }
                return -1D;
            }
        }
    }