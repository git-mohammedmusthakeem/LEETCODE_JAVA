class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int height = matrix.length;
        int width = matrix[0].length;
        for(int i = 0; i < height; i++){
            int col = binarySearchRow(matrix[i], target, 0, width - 1);
            if(col != -1) return true;
        }
        return false;
    }
    private static int binarySearchRow(int[] arr, int target, int low, int high){
        if(low > high) return -1;
        int mid = (low + high) / 2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] > target)
            return binarySearchRow(arr, target, low, mid - 1);
        else
            return binarySearchRow(arr, target, mid + 1, high);
    }
}