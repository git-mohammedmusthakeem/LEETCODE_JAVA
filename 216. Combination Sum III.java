class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        backtrace(k, n, temp, result, 0, 1);
        return result;
    }

    private void backtrace(int k, int n, List<Integer> temp, List<List<Integer>> result, int sum, int cur){
        if(temp.size() == k){
            if(sum == n){
                List<Integer> copy = new LinkedList<>(temp);
                result.add(copy);
            }
        }else{
            for(int i = cur; i <= 9; i++){
                temp.add(i);
                backtrace(k, n, temp, result, sum + i, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}