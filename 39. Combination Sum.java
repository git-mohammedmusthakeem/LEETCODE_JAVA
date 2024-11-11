class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(result, new ArrayList<Integer>(), 0, candidates, target, 0);
        return result;
    }
    private void backtrace(List<List<Integer>> result, List<Integer> temp, int sum, int[] candidates, int target, int start){
        if(sum == target){
            result.add(new ArrayList<Integer>(temp));
        }else if(sum < target){
            for(int i = start; i < candidates.length; i++){
                if(sum + candidates[i] > target) break;
                temp.add(candidates[i]);
                backtrace(result, temp, sum + candidates[i], candidates, target, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}