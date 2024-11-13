class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        backtrace(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    private void backtrace(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        else{
            for(int i = 0; i < nums.length; i++){
                if(!used[i]){
                    temp.add(nums[i]);
                    used[i] = true;
                    backtrace(result, temp, nums, used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}