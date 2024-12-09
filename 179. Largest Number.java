class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int len = nums.length;
        String[] strs = new String[len];
        for(int i = 0; i < len; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String cmp1 = s1 + s2;
                String cmp2 = s2 + s1;
                return cmp2.compareTo(cmp1);
            }
        });
        if(strs[0].startsWith("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++)
            sb.append(strs[i]);
        return sb.toString();
    }
}