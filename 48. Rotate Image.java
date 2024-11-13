class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int depth = matrix.length / 2;
        int len = matrix.length;
        for(int d = 0; d < depth; d++){
            int l = len - 2 * d - 1;
            for(int j = 0; j < l; j++){
                int temp = matrix[d + j][d];
                matrix[d + j][d] = matrix[len - d - 1][j + d];
                matrix[len - d - 1][j + d] = matrix[len - 1 - j - d][len - d - 1];
                matrix[len - 1 - j - d][len - d - 1] = matrix[d][len - 1 - d- j];
                matrix[d][len - 1 - d- j] = temp;
            }
        }
    }
}