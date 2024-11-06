class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        int temp = 0;
        while(j > i){
            int h1 = height[i];
            int h2 = height[j];
            temp = (j - i) * Math.min(h1, h2);
            if(temp > result) result = temp;
            if(h1 >= h2){
                j--;
                continue;
            }else{
                i++;
                continue;
            }
        }
        return result;
    }
}