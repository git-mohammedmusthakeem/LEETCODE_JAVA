class Solution {
        public List<Integer> countSmaller(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] arr = new int[nums.length];
            for(int i = nums.length - 1; i>= 0; i--){
                if(map.containsKey(nums[i])){
                    arr[i] = map.get(nums[i]);
                }
                else{
                    arr[i] = -1;
                }
                map.put(nums[i], i);
            }
            int[] result = new int[nums.length];
            for(int i = nums.length - 1; i >= 0; i--){
                int count = 0;
                if(arr[i] == -1){
                    for(int j = i; j < nums.length; j++){
                        if(nums[i] > nums[j]) count++;
                    }
                    result[i] = count;
                }else{
                    for(int j = i; j < arr[i]; j++){
                        if(nums[i] > nums[j]) count++;
                    }
                    result[i] = count + result[arr[i]];
                }
            }
            List<Integer> res = new LinkedList<>();
            for(int n : result) res.add(n);
            return res;
        }
    }