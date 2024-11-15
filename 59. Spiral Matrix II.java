class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0) return null;
        int[][] result = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int count = 1;
        result[0][0] = 1;
        int dir = 0, x = 0, y = 0;
        while(up <= down && left <= right){
            switch(dir){
                case 0:
                    while(++y <= right)
                        result[x][y] = ++count;
                    y--; up++;
                    dir = 1;
                    break;
                case 1:
                    while(++x <= down)
                        result[x][y] = ++count;
                    x--; right--;
                    dir = 2;
                    break;
                case 2:
                    while(--y >= left)
                        result[x][y] = ++count;
                    ++y; down--;
                    dir = 3;
                    break;
                case 3:
                    while(--x >= up)
                        result[x][y] = ++count;
                    ++x; left++;
                    dir = 0;
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}