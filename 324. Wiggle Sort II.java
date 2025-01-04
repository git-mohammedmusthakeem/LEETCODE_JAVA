class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int index = (len % 2 == 0) ? len / 2: len / 2 + 1;
        int[] arr = new int[index];
        int i = 0;
        for(; i < index; i++)
            arr[i] = nums[i];
        int[] sec = new int[len - index];
        for(; i < len; i++)
            sec[i - index] = nums[i];
        for(i = 0; i < index; i++){
            nums[2 * i] = arr[index - i - 1];
            if(2 * i + 1 < len)
                nums[2 * i + 1] = sec[sec.length - i - 1];
        }
    }
}