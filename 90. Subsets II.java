class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        if(nums.length == 0){
            return result;
        }
        backtrace(result, nums, nums.length - 1, new HashMap<Integer, Integer>());
        return result;
    }
    private void backtrace(List<List<Integer>> result, int[] nums, int index, Map<Integer, Integer> map){
        if(index == -1)
            result.add(new LinkedList<Integer>());
        else{
            backtrace(result, nums, index - 1, map);
            if(!map.containsKey(nums[index])){
                int size = result.size();
                map.put(nums[index], size);
                for(int i = 0; i < size; i++){
                    List<Integer> temp = new LinkedList<>(result.get(i));
                    temp.add(nums[index]);
                    result.add(temp);
                }
            }else{
                int count = map.get(nums[index]);
                List<List<Integer>> temp = new LinkedList<List<Integer>>();
                int size = result.size();
                for(int i = 0; i < count; i++){
                    List<Integer> l = new LinkedList<Integer>(result.get(size - 1 - i));
                    l.add(nums[index]);
                    temp.add(l);
                }
                result.addAll(temp);
            }
        }
    }
}