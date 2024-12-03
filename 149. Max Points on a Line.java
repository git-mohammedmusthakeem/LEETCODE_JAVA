class Solution {
        public int maxPoints(int[][] points) {
            int len = points.length;
            if(len <= 2) return len;
            int res = 0;
            for(int i = 0; i < len; i++){
                for(int j = i + 1; j < len; j++){
                    int temp = 2;
                    double x1 = (double)points[i][0];
                    double x2 = (double)points[j][0];
                    if(x1 != x2){
                        double y1 = (double)points[i][1];
                        double y2 = (double)points[j][1];
                        double s = (y2 - y1) / (x2 - x1);
                        double b = y1 - s * x1;
                        for(int k = 0; k < len; k++){
                            if(k == i || k == j) continue;
                            double x = (double)points[k][0];
                            double y = (double)points[k][1];
                            if(y == x * s + b) temp++;
                        }
                    }else{
                        for(int k = 0; k < len; k++){
                            if(k == i || k == j) continue;
                            double x = (double)points[k][0];
                            if(x == x1) temp++;
                        }
                    }
                    res = Math.max(res, temp);
                }
            }
            return res;
        }
    }