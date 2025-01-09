class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        Set<Integer> set = new HashSet<>();
        while(index1 < nums1.length && index2 < nums2.length){
            int a = nums1[index1++], b = nums2[index2++];
            System.out.println(a + " " +b);
            if(a == b){
                set.add(a);
            }else if(a < b){
                index2--;
            }else
                index1--;
        }
        int[] res = new int[set.size()];
        int i = 0;
        for(int num : set)
            res[i++] = num;
        return res;
    }
}