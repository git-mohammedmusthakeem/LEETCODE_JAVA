class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        if(nums == null || nums.length == 0) return list;
        String arrow = "->";
        Set<Integer> set = new HashSet<>();
        Integer head = null;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(!set.contains(num - 1)){
                if(head != null){
                    if(head != nums[i - 1]){
                        list.add(head + arrow + nums[i - 1]);
                    }else{
                        list.add(head +"");
                    }
                }
                head = num;
            }
            set.add(num);
        }
        if(head != null && nums[nums.length - 1] == head){
            list.add(head + "");
        }else{
            list.add(head + arrow + nums[nums.length - 1]);
        }
        return list;
    }
}