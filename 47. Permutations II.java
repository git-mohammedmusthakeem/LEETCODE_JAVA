class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        permuteUnique(result, new LinkedList<Integer>(), nums, new boolean[nums.length]);
        return result;
        
    }
    private void permuteUnique(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length) result.add(new LinkedList<>(temp));
        else{
            for(int i = 0; i < nums.length; i++){
                if(used[i]) continue;
                if(i > 0 && nums[i - 1] == nums[i] && used[i - 1])  continue;
                temp.add(nums[i]);
                used[i] = true;
                permuteUnique(result, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}