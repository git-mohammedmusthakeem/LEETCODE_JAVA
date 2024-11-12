class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        int maxLeft = height[0];
        int[] lefts = new int[len];
        int maxRight = height[len - 1];
        int[] rights = new int[len];
        for(int i = 1; i < len; i++){
            if(height[i] > maxLeft){
                maxLeft = height[i];
                continue;
            }
            lefts[i] = maxLeft - height[i];
        }
        for(int i = len - 2; i >= 0; i--){
            if(height[i] > maxRight){
                maxRight = height[i];
                continue;
            }
            rights[i] = maxRight - height[i];
        }
        int result = 0;
        for(int i = 0; i < len; i++)
            result += Math.min(lefts[i], rights[i]);
        return result;
    }
}
