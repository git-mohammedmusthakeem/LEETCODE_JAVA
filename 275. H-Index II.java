class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < citations.length; i++){
            int curH = Math.min(citations[i], citations.length - i);
            result = Math.max(result, curH);
        }
        return result;
    }
}