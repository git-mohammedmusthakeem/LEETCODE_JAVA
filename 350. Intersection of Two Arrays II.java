class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        List<Integer> res = new ArrayList<>();
        while(index1 < nums1.length && index2 < nums2.length){
            int a = nums1[index1++], b = nums2[index2++];
            if(a == b)
                res.add(a);
            else if(a < b)
                index2--;
            else
                index1--;
        }
        int[] result = new int[res.size()];
        int i = 0;
        for(int num : res)
            result[i++] = num;
        return result;
    }
}