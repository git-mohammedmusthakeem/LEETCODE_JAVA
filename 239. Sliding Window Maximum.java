class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int len = nums.length;
        int[] result = new int[len - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        for(int i = 0; i < k; i++){
            pq.offer(nums[i]);
        }
        for(int i = k; i <= nums.length; i++){
            result[i - k] = pq.peek();
            pq.remove(nums[i - k]);
            if(i < nums.length)
                pq.offer(nums[i]);
        }
        return result;
    }
}