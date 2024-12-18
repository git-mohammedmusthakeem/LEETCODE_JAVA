class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        if(nums.length == 1){
            result.add(nums[0]);
            return result;
        }
        int major1 = 0, major2 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == major1)
                count1++;
            else if(major2 == nums[i])
                count2++;
            else if(count1 == 0){
                major1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                major2 = nums[i];
                count2 = 1;
            }else{
                count1 --;
                count2 --;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == major1) count1++;
            if(nums[i] == major2) count2++;
        }
        int cmp = nums.length / 3;
        if(count1 > cmp) result.add(major1);
        if(count2 > cmp && major2 != major1) result.add(major2);
        return result;
    }
}