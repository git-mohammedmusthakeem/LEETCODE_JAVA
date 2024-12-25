class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int result = 0;
        int cur = Integer.MIN_VALUE;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            cur = Math.min(citations.length - i, citations[i]);
            result = Math.max(cur, result);
        }
        return result;
    }
}