class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        int height = matrix.length, width = matrix[0].length;
        int up = 0, down = height - 1, left = 0, right = width - 1;
        int dir = 0; //0:right, 1:down, 2:left, 3: up
        int x = 0, y = 0;
        result.add(matrix[0][0]);
        while(up <= down && right >= left){
            switch(dir){
                case 0:
                    while(++y <= right)
                        result.add(matrix[x][y]);
                    up++; y--;
                    dir = 1;
                    break;
                case 1:
                    while(++x <= down)
                        result.add(matrix[x][y]);
                    right--; x--;
                    dir = 2;
                    break;
                case 2:
                    while(--y >= left)
                        result.add(matrix[x][y]);
                    down--; y++;
                    dir = 3;
                    break;
                case 3:
                    while(--x >= up)
                        result.add(matrix[x][y]);
                    left++; x++;
                    dir = 0;
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}