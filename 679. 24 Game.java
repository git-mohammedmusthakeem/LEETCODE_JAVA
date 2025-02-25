class Solution {
        public boolean judgePoint24(int[] nums) {
            List<Double> list = new ArrayList<Double>();
            for(int num : nums) list.add(num * 1D);
            return dfs(list);
        }
        private boolean dfs(List<Double> list){
            int size = list.size();
            if(size == 1 && Math.abs(list.get(0) - 24) < 0.0001) return true;
            for(int i = 0; i < size; i++){
                for(int j = i + 1; j < size; j++){
                    List<Double> possibles = getPossibles(list.get(i), list.get(j));
                    for(double p : possibles){
                        List<Double> next = new ArrayList<>();
                        next.add(p);
                        for(int k = 0; k < size; k++){
                            if(k == i || k == j) continue;
                            next.add(list.get(k));
                        }
                        if(dfs(next)) return true;
                    }
                }
            }
            return false;
        }
        private List<Double> getPossibles(double a, double b){
            List<Double> result = new ArrayList<>();
            result.add(a + b);
            result.add(a * b);
            result.add(a - b);
            result.add(b - a);
            result.add(a / b);
            result.add(b / a);
            return result;
        }
    }