class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int[] height = new int[matrix[0].length + 1];
        for(int row = 0; row < matrix.length; row++){
            for(int i = 0; i < matrix[0].length; i++){
                if(matrix[row][i] == '1') height[i]++;
                else height[i] = 0;
            }
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j <= matrix[0].length; j++){
                while(!stack.isEmpty() && height[j] < height[stack.peek()]){
                    int h = height[stack.pop()];
                    int index = stack.isEmpty() ? -1: stack.peek();
                    res = Math.max(res, h * (j - index - 1));
                }
                stack.push(j);
            }
        }
        return res;
    }
}