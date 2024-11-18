class Solution {
    public void setZeroes(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        for(int i = 0; i < height; i++)
            if(matrix[i][0] == 0) firstCol = true;
        for(int i = 0; i < width; i++)
            if(matrix[0][i] == 0) firstRow = true;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < height; i++)
            if(matrix[i][0] == 0) clearRow(matrix, i);
        for(int i = 1; i < width; i++)
            if(matrix[0][i] == 0) clearCol(matrix, i);
        if(firstRow) clearRow(matrix, 0);
        if(firstCol) clearCol(matrix, 0);
    }
    private void clearRow(int[][] matrix, int row){
        int width = matrix[0].length;
        for(int i = 1; i < width; i++){
            matrix[row][i] = 0;
        }
    }
    private void clearCol(int[][] matrix, int col){
        int height = matrix.length;
        for(int i = 0; i < height; i++){
            matrix[i][col] = 0;
        }
    }
}
```
