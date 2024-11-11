class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(result, new ArrayList<Integer>(), candidates, target, 0, 0);
        return result;
    }
    private void backtrace(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int sum, int start){
        if(sum == target){
            result.add(new ArrayList<>(temp));
        }else if(sum < target){
            int used = -1;
            for(int i = start; i < candidates.length; i++){
                if(sum + candidates[i] > target) return;
                if(used == -1) used = candidates[i];
                else if(used == candidates[i]) continue;
                else used = candidates[i];
                temp.add(candidates[i]);
                backtrace(result, temp, candidates, target, sum + candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}